package simple;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "firstBean")
@SessionScoped
public class ExampleBean implements Serializable {
    private String name;

    @PostConstruct
    private void initialize(){
        name = "Hello";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAction(){
        name = "";
    }
}
