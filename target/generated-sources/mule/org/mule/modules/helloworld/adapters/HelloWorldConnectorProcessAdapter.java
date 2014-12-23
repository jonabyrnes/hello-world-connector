
package org.mule.modules.helloworld.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.helloworld.HelloWorldConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>HelloWorldConnectorProcessAdapter</code> is a wrapper around {@link HelloWorldConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2014-12-23T12:27:18-05:00", comments = "Build UNNAMED.2039.0541b23")
public class HelloWorldConnectorProcessAdapter
    extends HelloWorldConnectorLifecycleAdapter
    implements ProcessAdapter<HelloWorldConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, HelloWorldConnectorCapabilitiesAdapter> getProcessTemplate() {
        final HelloWorldConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,HelloWorldConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, HelloWorldConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, HelloWorldConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
