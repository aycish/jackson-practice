package com.example.jacksonpractice.general;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonViewItem {
    @JsonView(UserViews.Public.class)
    public int id;

    @JsonView(UserViews.Public.class)
    public String itemName;

    @JsonView(UserViews.Private.class)
    public String ownerName;
}
