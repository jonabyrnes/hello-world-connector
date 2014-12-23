
package org.mule.modules.helloworld.adapters;

import javax.annotation.Generated;
import org.mule.modules.helloworld.HelloWorldConnector;
import org.mule.modules.helloworld.connection.Connection;


/**
 * A <code>HelloWorldConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link HelloWorldConnector } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2014-12-23T12:27:18-05:00", comments = "Build UNNAMED.2039.0541b23")
public class HelloWorldConnectorConnectionIdentifierAdapter
    extends HelloWorldConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
