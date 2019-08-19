package com.metaring.framework.email;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.apache.calcite.linq4j.Enumerable;
import org.apache.calcite.linq4j.Linq4j;
import com.metaring.framework.Tools;
import com.metaring.framework.type.DataRepresentation;
import com.metaring.framework.GeneratedCoreType;

public class MassiveTemplateEmailElementSeries extends ArrayList<MassiveTemplateEmailElement> implements GeneratedCoreType {

    private static final long serialVersionUID = 1L;
    private Enumerable<MassiveTemplateEmailElement> internalEnumerable;

    private MassiveTemplateEmailElementSeries(Iterable<MassiveTemplateEmailElement> iterable) {
        super();
        this.addAll(StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList()));
    }

    public static MassiveTemplateEmailElementSeries create(Iterable<MassiveTemplateEmailElement> iterable) {
        return new MassiveTemplateEmailElementSeries(iterable);
    }

    public static MassiveTemplateEmailElementSeries create(MassiveTemplateEmailElement... massiveTemplateEmailElements) {
        return create(massiveTemplateEmailElements == null ? new ArrayList<>() : Arrays.asList(massiveTemplateEmailElements));
    }

    public MassiveTemplateEmailElement[] toArray() {
        return this.toArray(new MassiveTemplateEmailElement[this.size()]);
    }


    public Enumerable<MassiveTemplateEmailElement> asEnumerable() {
        return internalEnumerable != null ? internalEnumerable : (internalEnumerable = Linq4j.asEnumerable(this));
    }

    public boolean addAll(Enumerable<MassiveTemplateEmailElement> enumerable) {
        return enumerable == null ? false : this.addAll(enumerable.toList());
    }

    public boolean containsAll(Enumerable<MassiveTemplateEmailElement> enumerable) {
        return enumerable == null ? false : this.containsAll(enumerable.toList());
    }

    public boolean removeAll(Enumerable<MassiveTemplateEmailElement> enumerable) {
        return enumerable == null ? false : this.removeAll(enumerable.toList());
    }

    public boolean retainAll(Enumerable<MassiveTemplateEmailElement> enumerable) {
        return enumerable == null ? false : this.retainAll(enumerable.toList());
    }

    public boolean addAll(MassiveTemplateEmailElement[] array) {
        return array == null ? false : this.addAll(Arrays.asList(array));
    }

    public boolean containsAll(MassiveTemplateEmailElement[] array) {
        return array == null ? false : this.containsAll(Arrays.asList(array));
    }

    public boolean removeAll(MassiveTemplateEmailElement[] array) {
        return array == null ? false : this.removeAll(Arrays.asList(array));
    }

    public boolean retainAll(MassiveTemplateEmailElement[] array) {
        return array == null ? false : this.retainAll(Arrays.asList(array));
    }

    private void recreateEnumerable() {
        if (internalEnumerable != null) {
            internalEnumerable = Linq4j.asEnumerable(this);
        }
    }

    @Override
    public boolean add(MassiveTemplateEmailElement e) {
        boolean test = super.add(e);
        recreateEnumerable();
        return test;
    }

    @Override
    public void add(int index, MassiveTemplateEmailElement element) {
        super.add(index, element);
        recreateEnumerable();
    }

    @Override
    public boolean addAll(Collection<? extends MassiveTemplateEmailElement> c) {
        boolean test = super.addAll(c);
        recreateEnumerable();
        return test;
    }

    @Override
    public boolean addAll(int index, Collection<? extends MassiveTemplateEmailElement> c) {
        boolean test = super.addAll(index, c);
        recreateEnumerable();
        return test;
    }

    @Override
    public boolean remove(Object o) {
        boolean test = super.remove(o);
        recreateEnumerable();
        return test;
    }

    @Override
    public MassiveTemplateEmailElement remove(int index) {
        MassiveTemplateEmailElement test = super.remove(index);
        recreateEnumerable();
        return test;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean test = super.removeAll(c);
        recreateEnumerable();
        return test;
    }

    @Override
    public boolean removeIf(Predicate<? super MassiveTemplateEmailElement> filter) {
        boolean test = super.removeIf(filter);
        recreateEnumerable();
        return test;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean test = super.retainAll(c);
        recreateEnumerable();
        return test;
    }

    @Override
    public void replaceAll(UnaryOperator<MassiveTemplateEmailElement> operator) {
        super.replaceAll(operator);
        recreateEnumerable();
    }

    public static MassiveTemplateEmailElementSeries fromJson(String jsonString) {
        if (jsonString == null) {
            return null;
        }
        jsonString = jsonString.trim();
        if(jsonString.isEmpty()) {
            return null;
        }
        if(jsonString.equalsIgnoreCase("null")) {
            return null;
        }

        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.fromJson(jsonString);
        List<MassiveTemplateEmailElement> list = new ArrayList<>();
        for(DataRepresentation data : dataRepresentation) {
            list.add(MassiveTemplateEmailElement.fromJson(data.asText()));
        }
        return new MassiveTemplateEmailElementSeries(list);
    }

    public static MassiveTemplateEmailElementSeries fromObject(Object object) {
        if (object == null) {
            return null;
        }

        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.fromObject(object);
        List<MassiveTemplateEmailElement> list = new ArrayList<>();
        for(DataRepresentation data : dataRepresentation) {
            list.add(MassiveTemplateEmailElement.fromJson(data.asText()));
        }
        return new MassiveTemplateEmailElementSeries(list);
    }

    public DataRepresentation toDataRepresentation() {
        return Tools.FACTORY_DATA_REPRESENTATION.fromJson(toJson());
    }

    @Override
    public String toJson() {
        StringBuilder sb = new StringBuilder("[");
        forEach(it -> sb.append(it.toJson()).append(","));
        return sb.delete(sb.length() - 1, sb.length()).append("]").toString();
    }

    @Override
    public String toString() {
        return toJson();
    }
}