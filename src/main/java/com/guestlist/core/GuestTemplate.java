package com.guestlist.core;

import com.google.common.base.Optional;

import static java.lang.String.format;

public class GuestTemplate {
    private final String content;
    private final String defaultName;

    public GuestTemplate(String content, String defaultName) {
        this.content = content;
        this.defaultName = defaultName;
    }
    
    public String render(Optional<String> name) {
        return format(content, name.or(defaultName));
    }
}
