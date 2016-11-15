/*
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR. Disclosure, Use or 
 * Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.smokeTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

public class SmokeTestUtils {

    private static final Logger LOGGER = Logger.getLogger(SmokeTestUtils.class);

    /** PUBLIC ACCESS */

    // Name of the Server the Content app runs
    public static final String HOST_NAME;

    // Environment can be DEV, TEST, UAT, QA or PROD etc
    public static final String APP_ENVIRONMENT;

    /** PRIVATE ONLY */

    private static final String ERROR_UNKNOWN_HOST = "Unknown Host";

    // System properties
    public static final String SYSTEM_CONTAINER_HOST = "container.host";
    public static final String SYSTEM_CONTAINER_PORT = "container.port";
    public static final String SYSTEM_ENVIRONMENT = "environment";

    /**
     * Used to identify the context property that holds the HTTP request object.
     */
    public static final String TEST_CTX_REQUEST = "Request";

    /**
     * Used to identify the context property that holds the HTTP response
     * object.
     */
    public static final String TEST_CTX_RESPONSE = "Response";

    /**
     * Used to identify the context property that holds the servlet context
     * object.
     */
    public static final String TEST_CTX_SERVLET_CONTEXT = "ServletContext";

    /**
     * Static initialization of the static final variables: Created only one
     * time when the class is loaded.
     */
    static {
        HOST_NAME = findHostName();
        APP_ENVIRONMENT = findEnvironmentName();
    }

    /**
     * Constructor is declared private, so this class cannot be instantiated by
     * other classes.
     */
    private SmokeTestUtils() {

    }

    /**
     * Gets the host name of the server on which the app runs
     * 
     * @return
     */
    private static String findHostName() {
        String serverName = null;

        try {
            java.net.InetAddress address = java.net.InetAddress.getLocalHost();
            if (address != null) {
                serverName = address.getHostName();
            }
        } catch (UnknownHostException uhe) {
            LOGGER.error("An error occured when getting the host name", uhe);
        } catch (Exception ex) {
            LOGGER.error("An error occured when getting the host name", ex);
        }

        if (serverName == null) {
            serverName = ERROR_UNKNOWN_HOST;
        }

        return serverName;

    } // end of getHostName

    private static String findEnvironmentName() {
        return getLookupValue("Environment");
    }

    /**
     * Returns the JNDI lookup value as defined in the context file.
     * 
     * @param uriName
     * @return
     */
    public static String getLookupValue(String lookupName) {
        String lookupValue = "";
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            lookupValue = (String) ctx.lookup(lookupName);
            LOGGER.debug(lookupName + " : " + lookupValue);
        } catch (NamingException ne) {
            String errMsg = "Error getting lookupValue for lookupName: " + lookupName;
            LOGGER.error(errMsg, ne);
        }
        return lookupValue;
    }

    /**
     * Converts the exception stack trace to String and returns the String.
     * 
     * @param ex
     * @return
     */
    public static String getExceptionStackTrace(Exception ex) {
        if (ex != null) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(out);
            ex.printStackTrace(ps);
            return out.toString();
        } else {
            return "";
        }
    }

    /**
     * This method is called to check if patternStr expressed as a reg exp
     * exists in the searchStr
     * 
     * @param searchStr
     * @return
     */
    public static boolean findUsingRegExp(String searchStr, String patternStr) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(searchStr);
        matcher.useAnchoringBounds(false);

        return matcher.find();
    }

    /**
     * Returns highest value.
     * 
     * @param previous
     * @param next
     * @return
     */
    public static int getHighestValue(int previous, int next) {
        int highestValue = previous;
        if (next > previous) {
            highestValue = next;
        }
        return highestValue;
    }
}
