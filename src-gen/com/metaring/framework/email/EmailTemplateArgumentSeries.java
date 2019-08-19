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

public class EmailTemplateArgumentSeries extends ArrayList<EmailTemplateArgument> implements GeneratedCoreType {

    private static final long serialVersionUID = 1L;
    private Enumerable<EmailTemplateArgument> internalEnumerable;

    private EmailTemplateArgumentSeries(Iterable<EmailTemplateArgument> iterable) {
        super();
        this.addAll(StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList()));
    }

    public static EmailTemplateArgumentSeries create(Iterable<EmailTemplateArgument> iterable) {
        return new EmailTemplateArgumentSeries(iterable);
    }

    public static EmailTemplateArgumentSeries create(EmailTemplateArgument... emailTemplateArguments) {
        return create(emailTemplateArguments == null ? new ArrayList<>() : Arrays.asList(emailTemplateArguments));
    }

    public EmailTemplateArgument[] toArray() {
        return this.toArray(new EmailTemplateArgument[this.size()]);
    }


    public Enumerable<EmailTemplateArgument> asEnumerable() {
        return internalEnumerable != null ? internalEnumerable : (internalEnumerable = Linq4j.asEnumerable(this));
    }

    public boolean addAll(Enumerable<EmailTemplateArgument> enumerable) {
        return enumerable == null ? false : this.addAll(enumerable.toList());
    }

    public boolean containsAll(Enumerable<EmailTemplateArgument> enumerable) {
        return enumerable == null ? false : this.containsAll(enumerable.toList());
    }

    public boolean removeAll(Enumerable<EmailTemplateArgument> enumerable) {
        return enumerable == null ? false : this.removeAll(enumerable.toList());
    }

    public boolean retainAll(Enumerable<EmailTemplateArgument> enumerable) {
        return enumerable == null ? false : this.retainAll(enumerable.toList());
    }

    public boolean addAll(EmailTemplateArgument[] array) {
        return array == null ? false : this.addAll(Arrays.asList(array));
    }

    public boolean containsAll(EmailTemplateArgument[] array) {
        return array == null ? false : this.containsAll(Arrays.asList(array));
    }

    public boolean removeAll(EmailTemplateArgument[] array) {
        return array == null ? false : this.removeAll(Arrays.asList(array));
    }

    public boolean retainAll(EmailTemplateArgument[] array) {
        return array == null ? false : this.retainAll(Arrays.asList(array));
    }

    private void recreateEnumerable() {
        if (internalEnumerable != null) {
            internalEnumerable = Linq4j.asEnumerable(this);
        }
    }

    @Override
    public boolean add(EmailTemplateArgument e) {
        boolean test = super.add(e);
        recreateEnumerable();
        return test;
    }

    @Override
    public void add(int index, EmailTemplateArgument element) {
        super.add(index, element);
        recreateEnumerable();
    }

    @Override
    public boolean addAll(Collection<? extends EmailTemplateArgument> c) {
        boolean test = super.addAll(c);
        recreateEnumerable();
        return test;
    }

    @Override
    public boolean addAll(int index, Collection<? extends EmailTemplateArgument> c) {
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
    public EmailTemplateArgument remove(int index) {
        EmailTemplateArgument test = super.remove(index);
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
    public boolean removeIf(Predicate<? super EmailTemplateArgument> filter) {
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
    public void replaceAll(UnaryOperator<EmailTemplateArgument> operator) {
        super.replaceAll(operator);
        recreateEnumerable();
    }

    public static EmailTemplateArgumentSeries fromJson(String jsonString) {
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
        List<EmailTemplateArgument> list = new ArrayList<>();
        for(DataRepresentation data : dataRepresentation) {
            list.add(EmailTemplateArgument.fromJson(data.asText()));
        }
        return new EmailTemplateArgumentSeries(list);
    }

    public static EmailTemplateArgumentSeries fromObject(Object object) {
        if (object == null) {
            return null;
        }

        DataRepresentation dataRepresentation = Tools.FACTORY_DATA_REPRESENTATION.fromObject(object);
        List<EmailTemplateArgument> list = new ArrayList<>();
        for(DataRepresentation data : dataRepresentation) {
            list.add(EmailTemplateArgument.fromJson(data.asText()));
        }
        return new EmailTemplateArgumentSeries(list);
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