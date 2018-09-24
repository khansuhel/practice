package com.base.di_mappings;

import com.base.repository.InMemoryInventory;
import com.base.repository.Inventory;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class MappingModule extends AbstractModule
{
    protected void configure()
    {
        bind(Inventory.class).to(InMemoryInventory.class).in(Scopes.SINGLETON);
    }
}
