package prof.prodageo.org;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("prof.prodageo.org.MyAppWidgetset")
public class MyUI extends UI {
        
        
        final VerticalLayout layout = new VerticalLayout();
        final TextField name = new TextField();
        final TextField surname = new TextField();
        Button button = null ;
        

    /* explicit callback */
    class ClickMeClass implements Button.ClickListener
    {
        void buttonClick(Button.ClickEvent event) 
        {
            layout.addComponent(new Label("Thanks " + name.getValue() + ", it works!"));
        }
    }
        
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        /*
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        final TextField surname = new TextField();
        surname.setCaption("Type your surname here:");

        Button button = new Button("Click Me");
        */

        surname.setCaption("Type your surname here:");
        name.setCaption("Type your name here:");
        button = new Button("Click Me");
        ClickMeClass callback = new ClickMeClass() ;
        button.addClickListener( callback ) ;
        
        /*
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        */
        
        layout.addComponents(name, surname, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    

}
