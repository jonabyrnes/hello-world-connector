
package org.mule.modules.helloworld.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.modules.helloworld.adapters.HelloWorldConnectorConnectionIdentifierAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.5.2", date = "2014-12-23T12:27:18-05:00", comments = "Build UNNAMED.2039.0541b23")
public class HelloWorldConnectorConnectionFactory implements KeyedPoolableObjectFactory
{

    private static Logger logger = LoggerFactory.getLogger(HelloWorldConnectorConnectionFactory.class);
    private HelloWorldConnectorConnectionManager connectionManager;

    public HelloWorldConnectorConnectionFactory(HelloWorldConnectorConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Object makeObject(Object key)
        throws Exception
    {
        if (!(key instanceof HelloWorldConnectorConnectionKey)) {
            if (key == null) {
                logger.warn("Connection key is null");
            } else {
                logger.warn("Cannot cast key of type ".concat(key.getClass().getName().concat(" to ").concat("org.mule.modules.helloworld.connectivity.HelloWorldConnectorConnectionKey")));
            }
            throw new RuntimeException("Invalid key type ".concat(key.getClass().getName()));
        }
        HelloWorldConnectorConnectionIdentifierAdapter connector = new HelloWorldConnectorConnectionIdentifierAdapter();
        connector.setMyProperty(connectionManager.getMyProperty());
        if (connector instanceof MuleContextAware) {
            ((MuleContextAware) connector).setMuleContext(connectionManager.getMuleContext());
        }
        if (connector instanceof Initialisable) {
            ((Initialisable) connector).initialise();
        }
        if (connector instanceof Startable) {
            ((Startable) connector).start();
        }
        if (!connector.isConnected()) {
            connector.connect(((HelloWorldConnectorConnectionKey) key).getUsername(), ((HelloWorldConnectorConnectionKey) key).getPassword());
        }
        return connector;
    }

    public void destroyObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof HelloWorldConnectorConnectionKey)) {
            if (key == null) {
                logger.warn("Connection key is null");
            } else {
                logger.warn("Cannot cast key of type ".concat(key.getClass().getName().concat(" to ").concat("org.mule.modules.helloworld.connectivity.HelloWorldConnectorConnectionKey")));
            }
            throw new RuntimeException("Invalid key type ".concat(key.getClass().getName()));
        }
        if (!(obj instanceof HelloWorldConnectorConnectionIdentifierAdapter)) {
            if (obj == null) {
                logger.warn("Connector is null");
            } else {
                logger.warn("Cannot cast connector of type ".concat(obj.getClass().getName().concat(" to ").concat("org.mule.modules.helloworld.adapters.HelloWorldConnectorConnectionIdentifierAdapter")));
            }
            throw new RuntimeException("Invalid connector type ".concat(obj.getClass().getName()));
        }
        try {
            ((HelloWorldConnectorConnectionIdentifierAdapter) obj).disconnect();
        } catch (Exception e) {
            throw e;
        } finally {
            if (((HelloWorldConnectorConnectionIdentifierAdapter) obj) instanceof Stoppable) {
                ((Stoppable) obj).stop();
            }
            if (((HelloWorldConnectorConnectionIdentifierAdapter) obj) instanceof Disposable) {
                ((Disposable) obj).dispose();
            }
        }
    }

    public boolean validateObject(Object key, Object obj) {
        if (!(obj instanceof HelloWorldConnectorConnectionIdentifierAdapter)) {
            if (obj == null) {
                logger.warn("Connector is null");
            } else {
                logger.warn("Cannot cast connector of type ".concat(obj.getClass().getName().concat(" to ").concat("org.mule.modules.helloworld.adapters.HelloWorldConnectorConnectionIdentifierAdapter")));
            }
            throw new RuntimeException("Invalid connector type ".concat(obj.getClass().getName()));
        }
        try {
            return ((HelloWorldConnectorConnectionIdentifierAdapter) obj).isConnected();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    public void activateObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof HelloWorldConnectorConnectionKey)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof HelloWorldConnectorConnectionIdentifierAdapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        try {
            if (!((HelloWorldConnectorConnectionIdentifierAdapter) obj).isConnected()) {
                ((HelloWorldConnectorConnectionIdentifierAdapter) obj).connect(((HelloWorldConnectorConnectionKey) key).getUsername(), ((HelloWorldConnectorConnectionKey) key).getPassword());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void passivateObject(Object key, Object obj)
        throws Exception
    {
    }

}
