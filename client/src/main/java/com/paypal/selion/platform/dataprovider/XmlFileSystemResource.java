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

package com.paypal.selion.platform.dataprovider;

import java.util.Collections;
import java.util.Map;

/**
 * Extends {@link FileSystemResource} class to support XML file as a DataProvider to be used by
 * {@link com.paypal.selion.platform.dataprovider.XmlDataProvider}.
 *
 */
public class XmlFileSystemResource extends FileSystemResource {

    private Map<String, Class<?>> xpathMap = Collections.<String, Class<?>>emptyMap();

    /**
     * Constructor to accept XML filename at specified path, and declared type indicated by {@code cls} represented by
     * the XML data.
     * 
     * @param pathName
     *            The path representing the directory where the {@code fileName} is located.
     * @param fileName
     *            The name of the file.
     * @param cls
     *            The declared type modeled by the XML content in the file at {@code pathName}/{@code fileName}.
     */
    public XmlFileSystemResource(String pathName, String fileName, Class<?> cls) {
        super(pathName, fileName, cls);
    }

    /**
     * Constructor to accept full path of XML file, and declared type indicated by {@code cls} represented by the XML
     * data.
     * 
     * @param fileName
     *            The complete path of the file resource including the file name.
     * @param cls
     *            The declared type modeled by the XML content in the file at {@code fileName}.
     */
    public XmlFileSystemResource(String fileName, Class<?> cls) {
        super(fileName, cls);
    }

    /**
     * Constructor to accept XML filename at specified path, and multiple declared types at multiple XPaths represented
     * by the XML data.
     * 
     * @param pathName
     *            The path representing the directory where the {@code fileName} is located.
     * @param fileName
     *            The name of the file.
     * @param xpathMap
     *            The map containing the XPath string and the type represented by the node evaluated using the XPath.
     */
    public XmlFileSystemResource(String pathName, String fileName, Map<String, Class<?>> xpathMap) {
        super(pathName, fileName);
        this.setXpathMap(xpathMap);
    }

    /**
     * Constructor to accept full path of XML file, and multiple declared types at multiple XPaths represented by the
     * XML data.
     * 
     * @param fileName
     *            The complete path of the file resource including the file name.
     * @param xpathMap
     *            The map containing the XPath string and the type represented by the node evaluated using the XPath.
     */
    public XmlFileSystemResource(String fileName, Map<String, Class<?>> xpathMap) {
        super(fileName);
        this.setXpathMap(xpathMap);
    }

    /**
     * Gets the map of {@code String} representing XPath and the type represented by the node evaluated by the XPath.
     * 
     * @return A {@code Map<String, Class<?>>} map. Returns null if the instance was not initialized using
     *         {@link XmlFileSystemResource#XmlFileSystemResource(String, Map)} or
     *         {@link XmlFileSystemResource#XmlFileSystemResource(String, String, Map)} constructors.
     */
    public Map<String, Class<?>> getXpathMap() {
        return xpathMap.isEmpty() ? null : xpathMap;
    }

    /**
     * Private setter for xpathMap.
     * 
     * @param xpathMap
     *            the xpathMap to set
     */
    private void setXpathMap(Map<String, Class<?>> xpathMap) {
        this.xpathMap = xpathMap;
    }

}
