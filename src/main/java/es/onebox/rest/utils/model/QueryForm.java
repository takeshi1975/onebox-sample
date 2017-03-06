package es.onebox.rest.utils.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

/**
 * Bean that stores query parameters
 *
 * @author Oreste Luci
 */
public class QueryForm {

    @NotNull
    @Size(min = 1, message="{error.validation.query.url}")
    private String url;

    @NotNull
    private String accept;

    @NotNull
    private String method;

    /**
     * Internal representation of post names
     */
    private Map<String,String> names = new TreeMap<>();

    /**
     * Internal representation of post values
     */
    private Map<String,String> values = new TreeMap<>();

    private Integer paramCount = new Integer(0);

    public QueryForm() {
        initPostParams();
    }

    public Integer getParamCount() {
        return paramCount;
    }

    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
    }

    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }

    /**
     * @return Returns form parameters as a MultiMap for easier handling
     */
    public MultiMap getFormParameters() {

        MultiMap paramsMap = new MultiValueMap();

        if (names.isEmpty() || values.isEmpty()) {
            return paramsMap;
        }

        removeEmpty();

        Iterator<String> nameKeys = names.keySet().iterator();

        String nameKey,name,value;
        while(nameKeys.hasNext()) {

            nameKey = nameKeys.next();
            name = names.get(nameKey);

            if (name!=null && name.length()>0) {
                value = values.get(nameKey);
                if (value != null && value.length() > 0) {
                    paramsMap.put(name, value);
                }
            }
        }

        return paramsMap;
    }

    /**
     * @return Returns parameters as string to place in post body.
     */
    public String getParametersAsString() {

        MultiMap paramsMap = getFormParameters();

        StringBuilder content = new StringBuilder();

        Iterator keySet = paramsMap.keySet().iterator();

        boolean first = true;
        while (keySet.hasNext()) {

            String key = (String)keySet.next();

            List<String> values = (List)paramsMap.get(key);

            if (!first)
                content.append("&");

            int count = 0;
            for (String value : values) {
                content.append(key).append("=").append(value);
                if (count>0) {
                    content.append("&");
                    count++;
                }
            }

            first = false;
        }

        return content.toString();
    }

    /**
     * Removes all names that have no values and all values that have no names
     */
    private void removeEmpty() {


        Iterator<String> nameKeys = names.keySet().iterator();
        ArrayList<String> removeKeys = new ArrayList<>();

        while(nameKeys.hasNext()) {

            String nameKey = nameKeys.next();
            String name = names.get(nameKey);

            if (name==null || name.trim().length()==0) {
                removeKeys.add(nameKey);
            }
        }

        Iterator<String> valueKeys = values.keySet().iterator();

        while(valueKeys.hasNext()) {

            String valueKey = valueKeys.next();
            String value = values.get(valueKey);

            if (value==null || value.trim().length()==0) {
                removeKeys.add(valueKey);
            }
        }

        for (String key : removeKeys) {
            names.remove(key);
            values.remove(key);
        }

        if (names.size()==0 && values.size()==0) {
            initPostParams();
        }
    }

    /**
     * Initializes required form data
     */
    private void initPostParams() {
        names.put("param0","");
        values.put("param0","");
    }

    /**
     * To determine if response should be mapped to objects
     * TODO: This feature needs to be finished
     */
    private Boolean mapResponse = new Boolean(false);

    public Boolean getMapResponse() {
        return mapResponse;
    }

    public void setMapResponse(Boolean mapResponse) {
        this.mapResponse = mapResponse;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return url;
    }
}
