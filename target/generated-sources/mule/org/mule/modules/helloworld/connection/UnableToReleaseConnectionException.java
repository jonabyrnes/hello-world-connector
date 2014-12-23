
package org.mule.modules.helloworld.connection;

import javax.annotation.Generated;


/**
 * Exception thrown when the release connection operation of the
 *  connection manager fails.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.2", date = "2014-12-23T12:27:18-05:00", comments = "Build UNNAMED.2039.0541b23")
public class UnableToReleaseConnectionException
    extends Exception
{

     /**
     * Create a new exception
     *
     * @param throwable Inner exception
     */
    public UnableToReleaseConnectionException(Throwable throwable) {
        super(throwable);
    }
}
