package dad.chat.models;

import java.util.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class HoraObservable extends Thread {

	private ObjectProperty<Date> date = new SimpleObjectProperty<>(this, "date");
	
	@Override
	public void run() {
		super.run();
		while (true) {
			date.set(new Date());
			try {
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public final ObjectProperty<Date> dateProperty() {
		return this.date;
	}

	public final Date getDate() {
		return this.dateProperty().get();
	}

	public final void setDate(final Date date) {
		this.dateProperty().set(date);
	}

}
