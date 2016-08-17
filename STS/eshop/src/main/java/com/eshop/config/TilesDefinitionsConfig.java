package com.eshop.config;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

import java.util.HashMap;
import java.util.Map;

public class TilesDefinitionsConfig implements DefinitionsFactory {
    private static final Map<String, Definition> tilesDefinitions = new HashMap<String,Definition>();
    private static final Attribute BASE_TEMPLATE = new Attribute("/layout/layout.jsp");

    @Override
    public Definition getDefinition(String name, Request tilesContext) {
        return tilesDefinitions.get(name);
    }

    /**
     * @param name <code>Name of the view</code>
     * @param title <code>Page title</code>
     * @param body <code>Body JSP file path</code>
     *
     * <code>Adds default layout definitions</code>
     */
    private static void addDefaultLayoutDef(String name, String title, String body) {
        Map<String, Attribute> attributes = new HashMap<String,Attribute>();
        attributes.put("title", new Attribute(title));
        attributes.put("head", new Attribute("/views/head.jsp"));
        attributes.put("navbar", new Attribute("/views/navbar.jsp"));
        attributes.put("body", new Attribute(body));
        attributes.put("footer", new Attribute("/views/footer.jsp"));
        attributes.put("scripts", new Attribute("/views/scripts.jsp"));
        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    /**
     * <code>Add Apache tiles definitions</code>
     */
    public static void addDefinitions(){
        addDefaultLayoutDef("main", "Main Page", "/views/listProducts.jsp");
        addDefaultLayoutDef("cart", "Cart", "/views/cart.jsp");
    }
}
