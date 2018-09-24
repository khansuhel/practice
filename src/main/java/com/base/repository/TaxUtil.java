package com.base.repository;

import com.base.model.TaxCategory;

public class TaxUtil
{
    public static int getTaxPercentage(TaxCategory category)
    {
        if (category.equals(TaxCategory.GST))
        {
            return 15;
        }
        else if (category.equals(TaxCategory.CGST))
        {
            return 10;
        }
        else
            return 5;
    }

}
