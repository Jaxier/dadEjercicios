package dad.codegen.model.java;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.io.FileUtils;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlType
@XmlRootElement
public class Repository {
	private ListProperty<Class> classes;

	public Repository() {
		classes = new SimpleListProperty<>(this, "classes", FXCollections.observableArrayList());
	}

	public ListProperty<Class> classesProperty() {
		return this.classes;
	}

	@XmlElement(name = "class")
	@XmlElementWrapper
	public ObservableList<Class> getClasses() {
		return this.classesProperty().get();
	}

	public void setClasses(final ObservableList<Class> classes) {
		this.classesProperty().set(classes);
	}
	
	public void save(File target) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Repository.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(this, target);
	}

	public static Repository load(File source) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Repository.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (Repository) unmarshaller.unmarshal(source);
	}
	
	private File makePackages(File parent,String packageName) {
		String dirs = packageName.replaceAll("\\.", "\\" + File.separator);
		File packagesFile = new File(parent, dirs);
		packagesFile.mkdirs();
		return packagesFile;
	}
	
	public void generateCode(File path) throws IOException {
		path.mkdirs();
		for (Class c : getClasses()) {
			File packageFile = makePackages(path, c.getPackageName());
			File classFile = new File(packageFile, c.getName() + ".java");
			FileUtils.writeStringToFile(classFile, c.asJavaCode(), "UTF-8");
		}
	}

}
