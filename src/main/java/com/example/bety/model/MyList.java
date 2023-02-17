package com.example.bety.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList implements List<String> {
    private String[] _data = null;
    private int _size = 0;

    public MyList() {
        _data = new String[]{};
        _size = 0;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < _data.length; ++i) {

            if (o == null && _data[i] == null) {
                return true;
            } else if (_data[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection)
            if (!contains(o))
                return false;

        return true;
    }

    @Override
    public boolean add(String s) {

        if (_data.length > _size) {
            _data[_size] = s;
        } else {
            String[] _tdata = new String[_data.length * 2];

            for (int i = 0; i < _size; ++i) {
                _tdata[i] = _data[i];
            }
            _tdata[_size] = s;
            _data = _tdata;
        }
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends String> collection) {
        for (String s : collection) {
            this.add(s);
        }
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends String> collection) {
        if (_size >= i || i < 0) {
            this.addAll(collection);
        } else {
            String[] _tdata = new String[_size - i - 1];
            for (int j = 0; j < _size - i - 1; ++j) {
                _tdata[j] = _data[i + 1 + j];
            }
            this.addAll(collection);
            this.addAll(List.of(_tdata));
        }
        return true;
    }


    /////////////////
    @Override
    public boolean remove(Object o) {
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String get(int i) {
        return null;
    }

    @Override
    public String set(int i, String s) {
        return null;
    }

    @Override
    public void add(int i, String s) {

    }

    @Override
    public String remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int i) {
        return null;
    }

    @Override
    public List<String> subList(int i, int i1) {
        return null;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }
}
