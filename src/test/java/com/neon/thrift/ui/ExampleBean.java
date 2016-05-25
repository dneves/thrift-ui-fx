package com.neon.thrift.ui;

public class ExampleBean {

    private String id;

    private String randomProperty;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleBean that = (ExampleBean) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return randomProperty != null ? randomProperty.equals(that.randomProperty) : that.randomProperty == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (randomProperty != null ? randomProperty.hashCode() : 0);
        return result;
    }
}
