
package org.mule.modules.helloworld.connectivity;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.helloworld.adapters.HelloWorldConnectorConnectionIdentifierAdapter;
import org.mule.modules.helloworld.connection.ConnectionManager;
import org.mule.modules.helloworld.process.HelloWorldConnectorManagedConnectionProcessInterceptor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.mule.security.oauth.process.ProcessCallbackProcessInterceptor;
import org.mule.security.oauth.process.RetryProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.5.2", date = "2014-12-23T12:27:18-05:00", comments = "Build UNNAMED.2039.0541b23")
public class HelloWorldConnectorManagedConnectionProcessTemplate<P >implements ProcessTemplate<P, HelloWorldConnectorConnectionIdentifierAdapter>
{

    private final ProcessInterceptor<P, HelloWorldConnectorConnectionIdentifierAdapter> processInterceptor;

    public HelloWorldConnectorManagedConnectionProcessTemplate(ConnectionManager<HelloWorldConnectorConnectionKey, HelloWorldConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, HelloWorldConnectorConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, HelloWorldConnectorConnectionIdentifierAdapter>();
        ProcessInterceptor<P, HelloWorldConnectorConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new HelloWorldConnectorManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, HelloWorldConnectorConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, HelloWorldConnectorConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, HelloWorldConnectorConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, HelloWorldConnectorConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
