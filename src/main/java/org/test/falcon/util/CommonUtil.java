package org.test.falcon.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.SortOrder;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.test.falcon.constant.Constant;
import org.test.falcon.exception.ProAPIException;

import com.mchange.v2.util.CollectionUtils;



public class CommonUtil {

    /**
     * Uses NullAwareBeanutil to copy properties and throws exception in case of
     * error
     * 
     * @param dest
     * @param orig
     */
    public static void copyInheritedDtoProperties(Object dest, Object orig) {
        InheritedFieldsEmptyListExclusionAwareBeanUtilsBean exNullAwareBeanUtilBean =
                new InheritedFieldsEmptyListExclusionAwareBeanUtilsBean();
        try {
            exNullAwareBeanUtilBean.copyProperties(dest, orig);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            throw new ProAPIException(e);
        }
    }

    /**
     * Uses NullAwareBeanutil to copy properties and throws exception in case of
     * error
     * 
     * @param dest
     * @param orig
     */
    public static void copyDtoProperties(Object dest, Object orig) {
        EmptyListExclusionAwareBeanUtilsBean exNullAwareBeanUtilBean = new EmptyListExclusionAwareBeanUtilsBean();
        try {
            exNullAwareBeanUtilBean.copyProperties(dest, orig);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            throw new ProAPIException(e);
        }
    }

    public static Integer getMax(Integer i1, Integer i2) {
        if (i1 != null && i2 != null) {
            return i1.compareTo(i2) == 0 ? i1 : (i1.compareTo(i2) > 0 ? i1 : i2);
        }
        else if (i1 != null && i2 == null) {
            return i1;
        }
        else if (i1 == null && i2 != null) {
            return i2;
        }
        else {
            return null;
        }
    }

    public static Integer getMin(Integer i1, Integer i2) {
        if (i1 != null && i2 != null) {
            return i1.compareTo(i2) == 0 ? i1 : (i1.compareTo(i2) < 0 ? i1 : i2);
        }
        else if (i1 != null && i2 == null) {
            return i1;
        }
        else if (i1 == null && i2 != null) {
            return i2;
        }
        else {
            return null;
        }
    }

    public static <T extends Object> List<T> getUnionOfLists(List<T> l1, List<T> l2) {
        if (l1 != null && l2 != null) {
            return Stream.concat(l1.stream(), l2.stream()).distinct().collect(Collectors.toList());
        }
        else if (l1 != null && l2 == null) {
            return l1;
        }
        else {
            return l2;
        }
    }


    public static boolean isCriteriaNotEmpty(Criteria criteria) {
        return !criteria.getCriteriaObject().keySet().isEmpty();
    }

    public static void update(Update update, String fieldName, Object value) {
        if (value != null) {
            update.set(fieldName, value);
        }
        else {
            update.unset(fieldName);
        }
    }

    public static void updateNotNull(Update update, String fieldName, Object value) {
        if (value != null) {
            update.set(fieldName, value);
        }
    }


    public static String wrapResponseTag(String tune) {
        return "<response>" + tune.replaceAll("\n", "") + "</response>";
    }

    public static <T extends Object> T clone(T object) {
        T clonedObj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(object);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            clonedObj = (T) in.readObject();
        }
        catch (Exception e) {
            throw new ProAPIException(e);
        }
        return clonedObj;
    }

    public static ObjectId getObjectIdByTime(Date date) {
        return new ObjectId(Long.toHexString(date.getTime() / 1000) + "0000000000000000");
    }
}
