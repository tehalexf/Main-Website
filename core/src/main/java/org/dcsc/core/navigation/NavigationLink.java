package org.dcsc.core.navigation;

public class NavigationLink {
    private String name;
    private String link;
    private String icon;

    public NavigationLink(String name, String link, String icon) {
        this.name = name;
        this.link = link;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}