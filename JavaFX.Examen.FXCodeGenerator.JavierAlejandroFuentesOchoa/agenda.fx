<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<fxModel packageName="dad.agenda.model">
    <bean name="Identificable">
        <property name="id" readOnly="false" type="LONG"/>
    </bean>
    <bean name="Telefono" parent="Identificable">
        <property name="numero" readOnly="false" type="STRING"/>
    </bean>
    <bean name="Persona" parent="Identificable">
        <property name="nombre" readOnly="false" type="STRING"/>
        <property name="apellidos" readOnly="false" type="STRING"/>
        <property name="fechaNacimiento" readOnly="false" type="DATE"/>
        <property name="edad" readOnly="true" type="INTEGER"/>
        <property generic="Telefono" name="telefonos" readOnly="false" type="LIST"/>
    </bean>
</fxModel>
