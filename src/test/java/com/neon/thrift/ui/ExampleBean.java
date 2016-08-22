package com.neon.thrift.ui;

public class ExampleBean {

    private String id;

    private String randomProperty;

    private ExampleEnum enumValue;

    public ExampleBean() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRandomProperty() {
        return randomProperty;
    }

    public void setRandomProperty(String randomProperty) {
        this.randomProperty = randomProperty;
    }

    public ExampleEnum getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(ExampleEnum enumValue) {
        this.enumValue = enumValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleBean that = (ExampleBean) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (randomProperty != null ? !randomProperty.equals(that.randomProperty) : that.randomProperty != null)
            return false;
        return enumValue == that.enumValue;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (randomProperty != null ? randomProperty.hashCode() : 0);
        result = 31 * result + (enumValue != null ? enumValue.hashCode() : 0);
        return result;
    }
}
