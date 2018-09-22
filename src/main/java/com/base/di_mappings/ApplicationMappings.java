package com.base.di_mappings;

import com.base.repository.DefaultInventory;
import com.base.repository.Inventory;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ApplicationMappings extends AbstractModule
{
    protected void configure()
    {
        bind(Inventory.class).to(DefaultInventory.class).in(Scopes.SINGLETON);
    }
}
