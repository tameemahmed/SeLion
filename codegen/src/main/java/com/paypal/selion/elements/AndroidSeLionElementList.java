/*----------------------------------------------------------------------------------------------------------------------------------------------------------*\
|  Copyright (C) 2015 eBay Software Foundation                                                                                                              |
|                                                                                                                                                           |
|  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance                                           |
|  with the License.                                                                                                                                        |
|                                                                                                                                                           |
|  You may obtain a copy of the License at                                                                                                                  |
|                                                                                                                                                           |
|       http://www.apache.org/licenses/LICENSE-2.0                                                                                                          |
|                                                                                                                                                           |
|  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed                                         |
|  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for                                        |
|  the specific language governing permissions and limitations under the License.                                                                           |
\*----------------------------------------------------------------------------------------------------------------------------------------------------------*/

package com.paypal.selion.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.paypal.selion.plugins.GUIObjectDetails;

public class AndroidSeLionElementList extends AbstractSeLionElementList {

    protected AndroidSeLionElementList(String elementPackage, String element, boolean uiElement) {
        super(elementPackage, element, uiElement);
    }

    /**
     * The android elements are added as custom elements and SeLion does not declare any elements specifically 
     * which explains the empty array to hold the custom elements.
     */
    private static AndroidSeLionElementList[] values = {};
    
    /**
     * By providing the qualified name of a custom element we can register it to the element array.
     * Custom elements are inserted before SeLion elements, if you use the same name it will overwrite the existing element.
     * 
     * @param element string of the qualified class
     */
    public static void registerElement(String element) {
        List<AndroidSeLionElementList> temp = new ArrayList<AndroidSeLionElementList>(Arrays.asList(values));
        
        temp.add(0, new AndroidSeLionElementList(HtmlElementUtils.getPackage(element), HtmlElementUtils.getClass(element), true));
        
        values = temp.toArray(new AndroidSeLionElementList[temp.size()]);
    }
    
    /**
     * @param rawType
     *            - The String using which an attempt to find a matching {@link AndroidSeLionElementList} is to be
     *            performed.
     * @return - A {@link AndroidSeLionElementList} if the type ends with one of the values of {@link AndroidSeLionElementList}
     *         that were passed as android elements (or) <code>null</code> if there were no matches.
     */
    public static AndroidSeLionElementList findMatch(String rawType) {
        return (AndroidSeLionElementList) findMatch(values, rawType);
    }
    
    /**
     * @param element
     *            - The element that needs to be tested for being a valid {@link AndroidSeLionElementList} and whose
     *            {@link AndroidSeLionElementList#isUIElement()} returns true.
     * @return - <code>true</code> if there was a match and <code>false</code> otherwise.
     */
    public static boolean isValidUIElement(String element) {
        return isValidUIElement(values, element);

    }
    
    
    public static List<GUIObjectDetails> getGUIObjectList(List<String> keys) {
        List<GUIObjectDetails> mobileObjectDetailsList = new ArrayList<GUIObjectDetails>();

        for (String key : keys) {
            AndroidSeLionElementList element = AndroidSeLionElementList.findMatch(key);
            if (element != null && element.isUIElement()) {
                GUIObjectDetails mobileObjectDetails = null;
                mobileObjectDetails = new GUIObjectDetails(element.stringify(), key, element.getElementPackage());
                mobileObjectDetailsList.add(mobileObjectDetails);
            }
        }
        return mobileObjectDetailsList;
    }

}
