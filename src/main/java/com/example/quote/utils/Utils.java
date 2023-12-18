package com.example.quote.utils;

import com.google.common.collect.Sets;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.Set;

import static java.util.Objects.isNull;

public class Utils {
    public static void copyNonNullProperties(Object src, Object target, String... ignoredFields) {
        keepNullPropertyNames(src, target, ignoredFields);
    }

    private static void keepNullPropertyNames(Object source, Object target, String... ignoredFields) {
        final BeanWrapperImpl src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = Sets.newHashSet(ignoredFields);
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (isNull(srcValue))
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        BeanUtils.copyProperties(source, target, emptyNames.toArray(result));
    }
}