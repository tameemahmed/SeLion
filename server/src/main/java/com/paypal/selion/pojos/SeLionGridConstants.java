/*-------------------------------------------------------------------------------------------------------------------*\
|  Copyright (C) 2015 eBay Software Foundation                                                                        |
|                                                                                                                     |
|  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance     |
|  with the License.                                                                                                  |
|                                                                                                                     |
|  You may obtain a copy of the License at                                                                            |
|                                                                                                                     |
|       http://www.apache.org/licenses/LICENSE-2.0                                                                    |
|                                                                                                                     |
|  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed   |
|  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for  |
|  the specific language governing permissions and limitations under the License.                                     |
\*-------------------------------------------------------------------------------------------------------------------*/

package com.paypal.selion.pojos;

import org.apache.commons.lang.SystemUtils;

/**
 * A Class which contains String constants used throughout SeLion Grid
 * 
 * Patterns & conventions used in naming the constants for this class
 * </br>
 * </br> - Anything that is a *DIR* ends with a trailing separator. File system dirs are platform specific ('\' Windows, 
 * '/' Unix). CLASSPATH resource dirs will always be '/'.
 * </br> - Anything that is a *FILE* is a file 
 * </br> - Anything that is a *URL* is relative to http://{hostname}:{port} 
 * </br> - Anything that is a *RESOURCE* is a jar resource that can be loaded via the CLASSPATH
 * </br> - Anything that is a *PAGE* is a HTML page 
 * </br> - Anything that is a *ARG* is a program argument 
 * </br> - Any single constant may utilize more than one of these patterns/conventions
 * </br>
 */
public class SeLionGridConstants {

    private SeLionGridConstants() {
        // Restricting Object creation
    }

    private static final String PLATFORM_RESOURCE_DIR = SystemUtils.IS_OS_WINDOWS ? "windows/" : "unix/";

    /**
     * Path prefix to pages along with the Grid API endpoint
     */
    private static final String GRID_PAGES_URL_PATH_PREFIX = "/grid/resources/pages/";

    /**
     * Path to the home directory from where the jar archive is launched
     */
    private static final String HOME_PATH = (SystemUtils.USER_HOME == null) ? SystemUtils.USER_DIR
            : SystemUtils.USER_HOME;

    /**
     * The location SeLion-Grid will use to read/write/install required files to
     */
    public static String SELION_HOME_DIR = HOME_PATH + "/.selion/";

    static {
        // allow for the user to override SELION_HOME via a system property
        if (System.getProperty("selionHome") != null) {
            SELION_HOME_DIR = System.getProperty("selionHome");
        }
        // Make sure SELION_HOME ends with a '/' or '\'
        if (!SELION_HOME_DIR.endsWith("/") && !SELION_HOME_DIR.endsWith("\\")) {
            SELION_HOME_DIR += "/";
        }

        SELION_HOME_DIR = adjustFileSeparatorForPlatform(SELION_HOME_DIR);
    }

    static String adjustFileSeparatorForPlatform(String path) {
        return path.replace("/", SystemUtils.FILE_SEPARATOR);
    }

    /**
     * Executable name for IEDriver
     */
    public static final String IE_DRIVER = "IEDriverServer.exe";

    /**
     * Platform specific executable name for chromedriver
     */
    public static final String CHROME_DRIVER = SystemUtils.IS_OS_WINDOWS ? "chromedriver.exe" : "chromedriver";

    /**
     * Platform specific executable name for phantomjs
     */
    public static final String PHANTOMJS_DRIVER = SystemUtils.IS_OS_WINDOWS ? "phantomjs.exe" : "phantomjs";

    /**
     * Relative directory for config files
     */
    private static final String CONFIG_DIR = "config/";

    /**
     * Resource path to the download.json file
     */
    public static final String DOWNLOAD_JSON_FILE_RESOURCE = "/" + CONFIG_DIR + "download.json";

    /**
     * Installed/Extracted path to the download.json file
     */
    public static final String DOWNLOAD_JSON_FILE = adjustFileSeparatorForPlatform(SELION_HOME_DIR + CONFIG_DIR
            + "download.json");

    /**
     * Installed path to the downloads directory
     */
    public static final String DOWNLOADS_DIR = adjustFileSeparatorForPlatform(SELION_HOME_DIR + "downloads/");

    /**
     * URL to the grid home page
     */
    public static final String GRID_HOME_PAGE_URL = GRID_PAGES_URL_PATH_PREFIX + "gridHomePage.html";

    /**
     * Resource path to the password change html template file
     */
    public static final String PASSWORD_CHANGE_PAGE_RESOURCE = "/pages/changePageGetDetails.html";

    /**
     * Resource path to the grid auto upgrade html template file
     */
    public static final String GRID_AUTO_UPGRADE_PAGE_RESOURCE = "/pages/gridAutoUpgradePage.html";

    /**
     * URL to the SeLion sauce grid home page
     */
    public static final String SAUCE_GRID_HOMEPAGE_URL = GRID_PAGES_URL_PATH_PREFIX + "sauceGridHomePage.html";

    /**
     * Resource path to the sauce config html file
     */
    public static final String SAUCE_CONFIG_UPDATE_PAGE_RESOURCE = "/pages/updateSauceConfigPage.html";

    /**
     * Resource path to the default SeLionConfig.json file
     */
    public static final String SELION_CONFIG_FILE_RESOURCE = "/" + CONFIG_DIR + PLATFORM_RESOURCE_DIR
            + "SeLionConfig.json";

    /**
     * Installed/Extracted path to the SeLionConfig.json file
     */
    public static final String SELION_CONFIG_FILE = adjustFileSeparatorForPlatform(SELION_HOME_DIR + CONFIG_DIR
            + "SeLionConfig.json");

    /**
     * Resource path to the default hubConfig.json file
     */
    public static final String HUB_CONFIG_FILE_RESOURCE = "/" + CONFIG_DIR + "hubConfig.json";

    /**
     * Resource path to the default hubSauceConfig.json file
     */
    public static final String HUB_SAUCE_CONFIG_FILE_RESOURCE = "/" + CONFIG_DIR + "hubSauceConfig.json";

    /**
     * Installed/Extracted path to the hubConfig.json file
     */
    public static final String HUB_CONFIG_FILE = adjustFileSeparatorForPlatform(SELION_HOME_DIR + CONFIG_DIR
            + "hubConfig.json");

    /**
     * Installed/Extracted path to the hubSauceConfig.json file
     */
    public static final String HUB_SAUCE_CONFIG_FILE = adjustFileSeparatorForPlatform(SELION_HOME_DIR + CONFIG_DIR
            + "hubSauceConfig.json");

    /**
     * Resource path to the default sauceConfig.json file
     */
    public static final String SAUCE_CONFIG_FILE_RESOURCE = "/" + CONFIG_DIR + "sauceConfig.json";

    /**
     * Installed/Extracted path to the sauceConfig.json file
     */
    public static final String SAUCE_CONFIG_FILE = adjustFileSeparatorForPlatform(SELION_HOME_DIR + CONFIG_DIR
            + "sauceConfig.json");

    /**
     * Resource path to the default logging.properties file
     */
    public static final String LOGGING_PROPERTIES_FILE_RESOURCE = "/" + CONFIG_DIR + "logging.properties";

    /**
     * Installed/Extracted path to the logging.properties file
     */
    public static final String LOGGING_PROPERTIES_FILE = adjustFileSeparatorForPlatform(SELION_HOME_DIR + CONFIG_DIR
            + "logging.properties");

    /**
     * Installed path to the SeLion-Grid log files
     */
    public static final String LOGS_DIR = adjustFileSeparatorForPlatform(SELION_HOME_DIR + "logs/");

    /**
     * Resource path to the default nodeConfig.json file
     */
    public static final String NODE_CONFIG_FILE_RESOURCE = "/" + CONFIG_DIR + PLATFORM_RESOURCE_DIR + "nodeConfig.json";

    /**
     * Installed/Extracted path to the nodeConfig.json file
     */
    public static final String NODE_CONFIG_FILE = adjustFileSeparatorForPlatform(SELION_HOME_DIR + CONFIG_DIR
            + "nodeConfig.json");

    /**
     * Dash argument for specifying an alternative Selion Grid json config file
     */
    public static final String SELION_CONFIG_ARG = "-selionConfig";

    /**
     * Dash argument for specifying an alternative Selenium hub json config file
     */
    public static final String HUB_CONFIG_ARG = "-hubConfig";

    /**
     * Dash argument for specifying the SeLion Grid hub type &lt;sauce&gt;
     */
    public static final String TYPE_ARG = "-type";

    /**
     * Dash argument for specifying the Selenium role &lt;hub|node&gt;
     */
    public static final String ROLE_ARG = "-role";

    /**
     * Dash argument for specifying an alternative Selenium node json config file
     */
    public static final String NODE_CONFIG_ARG = "-nodeConfig";

    /**
     * Dash argument for displaying the help text
     */
    public static final String HELP_ARG = "-help";
}
