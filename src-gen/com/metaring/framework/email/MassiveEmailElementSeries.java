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

public class MassiveEmailElementSeries extends ArrayList<MassiveEmailElement> implements GeneratedCoreType {

    private static final long serialVersionUID = 1L;
    private Enumerable<MassiveEmailElement> internalEnumerable;

    private MassiveEmailElementSeries(Iterable<MassiveEmailElement> iterable) {
        super();
        this.addAll(StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList()));
    }

    public static MassiveEmailElementSeries create(Iterable<MassiveEmailElement> iterable) {
        return new MassiveEmailElementSeries(iterable);
    }

    public static MassiveEmailElementSeries create(MassiveEmailElement... massiveEmailElements) {
        return create(massiveEmailElements == null ? new ArrayList<>() : Arrays.asList(massiveEmailElements));
    }

    public MassiveEmailElement[] toArray() {
        return this.toArray(new MassiveEmailElement[this.size()]);
    }


    public Enumerable<MassiveEmailElement> asEnumerable() {
        return internalEnumerable != null ? internalEnumerable : (internalEnumerable = Linq4j.asEnumerable(this));
    }

    public boolean addAll(Enumerable<MassiveEmailElement> enumerable) {
        return enumerable == null ? false : this.addAll(enumerable.toList());
    }

    public boolean containsAll(Enumerable<MassiveEmailElement> enumerable) {
        return enumerable == null ? false : this.containsAll(enumerable.toList());
    }

    public boolean removeAll(Enumerable<MassiveEmailElement> enumerable) {
        return enumerable == null ? false : this.removeAll(enumerable.toList());
    }

    public boolean retainAll(Enumerable<MassiveEmailElement> enumerable) {
        return enumerable == null ? false : this.retainAll(enumerable.toList());
    }

    public boolean addAll(MassiveEmailElement[] array) {
        return array == null ? false : this.addAll(Arrays.asList(array));
    }

    public boolean containsAll(MassiveEmailElement[] array) {
        return array == null ? false : this.containsAll(Arrays.asList(array));
    }

    public boolean removeAll(MassiveEmailElement[] array) {
        return array == null ? false : this.removeAll(Arrays.asList(array));
    }

    public boolean retainAll(MassiveEmailElement[] array) {
        return array == null ? false : this.retainAll(Arrays.asList(array));
    }

    private void recreateEnumerable() {
        if (internalEnumerable != null) {
            internalEnumerable = Linq4j.asEnumerable(this);
        }
    }

    @Override
    public boolean add(MassiveEmailElement e) {
        boolean test = super.add(e);
        recreateEnumerable();
        return test;
    }

    @Override
    public void add(int index, MassiveEmailElement element) {
        super.add(index, element);
        recreateEnumerable();
    }

    @Override
    public boolean addAll(Collection<? extends MassiveEmailElement> c) {
        boolean test = super.addAll(c);
        recreateEnumerable();
        return test;
    }

    @Override
    public boolean addAll(int index, Collection<? extends MassiveEmailElement> c) {
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
    public MassiveEmailElement remove(int index) {
        MassiveEmailElement test = super.remove(index);
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
    public boolean removeIf(Predicate<? super MassiveEmailElement> filter) {
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
    public void replaceAll(UnaryOperator<MassiveEmailElement> operator) {
        super.replaceAll(operator);
        recreateEnumerable();
    }

    public static MassiveEmailElementSeries fromJson(String jsonString) {
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
        List<MassiveEmailElement> list = new ArrayList<>();
        for(DataRepresentation data : dataRepresentation) {
            list.add(MassiveEmailElement.fromJson(data.asText()));
        }
        return new MassiveEmailElementSeries(list);
    }

    public static MassiveEmailElementSeries fromObject(Object object) {
        if (object == null) {
            return null;
        }

        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.fromObject(object);
        List<MassiveEmailElement> list = new ArrayList<>();
        for(DataRepresentation data : dataRepresentation) {
            list.add(MassiveEmailElement.fromJson(data.asText()));
        }
        return new MassiveEmailElementSeries(list);
    }

    public DataRepresentation toDataRepresentation() {
        return Tools.FACTORY_DATA_REPRESENTATION.fromJson(toJson());
    }

    @Override
    public String toJson() {
        StringBuilder sb = new StringBuilder("[");
        if(!isEmpty()) {
            forEach(it -> sb.append(it.toJson()).append(","));
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.append("]").toString();
    }

    @Override
    public String toString() {
        return toJson();
    }
}