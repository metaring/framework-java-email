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

public class MassiveLocalizedEmailElementSeries extends ArrayList<MassiveLocalizedEmailElement> implements GeneratedCoreType {

    private static final long serialVersionUID = 1L;
    private Enumerable<MassiveLocalizedEmailElement> internalEnumerable;

    private MassiveLocalizedEmailElementSeries(Iterable<MassiveLocalizedEmailElement> iterable) {
        super();
        this.addAll(StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList()));
    }

    public static MassiveLocalizedEmailElementSeries create(Iterable<MassiveLocalizedEmailElement> iterable) {
        return new MassiveLocalizedEmailElementSeries(iterable);
    }

    public static MassiveLocalizedEmailElementSeries create(MassiveLocalizedEmailElement... massiveLocalizedEmailElements) {
        return create(massiveLocalizedEmailElements == null ? new ArrayList<>() : Arrays.asList(massiveLocalizedEmailElements));
    }

    public MassiveLocalizedEmailElement[] toArray() {
        return this.toArray(new MassiveLocalizedEmailElement[this.size()]);
    }


    public Enumerable<MassiveLocalizedEmailElement> asEnumerable() {
        return internalEnumerable != null ? internalEnumerable : (internalEnumerable = Linq4j.asEnumerable(this));
    }

    public boolean addAll(Enumerable<MassiveLocalizedEmailElement> enumerable) {
        return enumerable == null ? false : this.addAll(enumerable.toList());
    }

    public boolean containsAll(Enumerable<MassiveLocalizedEmailElement> enumerable) {
        return enumerable == null ? false : this.containsAll(enumerable.toList());
    }

    public boolean removeAll(Enumerable<MassiveLocalizedEmailElement> enumerable) {
        return enumerable == null ? false : this.removeAll(enumerable.toList());
    }

    public boolean retainAll(Enumerable<MassiveLocalizedEmailElement> enumerable) {
        return enumerable == null ? false : this.retainAll(enumerable.toList());
    }

    public boolean addAll(MassiveLocalizedEmailElement[] array) {
        return array == null ? false : this.addAll(Arrays.asList(array));
    }

    public boolean containsAll(MassiveLocalizedEmailElement[] array) {
        return array == null ? false : this.containsAll(Arrays.asList(array));
    }

    public boolean removeAll(MassiveLocalizedEmailElement[] array) {
        return array == null ? false : this.removeAll(Arrays.asList(array));
    }

    public boolean retainAll(MassiveLocalizedEmailElement[] array) {
        return array == null ? false : this.retainAll(Arrays.asList(array));
    }

    private void recreateEnumerable() {
        if (internalEnumerable != null) {
            internalEnumerable = Linq4j.asEnumerable(this);
        }
    }

    @Override
    public boolean add(MassiveLocalizedEmailElement e) {
        boolean test = super.add(e);
        recreateEnumerable();
        return test;
    }

    @Override
    public void add(int index, MassiveLocalizedEmailElement element) {
        super.add(index, element);
        recreateEnumerable();
    }

    @Override
    public boolean addAll(Collection<? extends MassiveLocalizedEmailElement> c) {
        boolean test = super.addAll(c);
        recreateEnumerable();
        return test;
    }

    @Override
    public boolean addAll(int index, Collection<? extends MassiveLocalizedEmailElement> c) {
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
    public MassiveLocalizedEmailElement remove(int index) {
        MassiveLocalizedEmailElement test = super.remove(index);
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
    public boolean removeIf(Predicate<? super MassiveLocalizedEmailElement> filter) {
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
    public void replaceAll(UnaryOperator<MassiveLocalizedEmailElement> operator) {
        super.replaceAll(operator);
        recreateEnumerable();
    }

    public static MassiveLocalizedEmailElementSeries fromJson(String jsonString) {
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
        List<MassiveLocalizedEmailElement> list = new ArrayList<>();
        for(DataRepresentation data : dataRepresentation) {
            list.add(MassiveLocalizedEmailElement.fromJson(data.asText()));
        }
        return new MassiveLocalizedEmailElementSeries(list);
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