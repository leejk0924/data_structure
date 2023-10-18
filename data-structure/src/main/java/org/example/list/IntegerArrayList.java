package org.example.list;

public class IntegerArrayList implements IntegerListInterface {
    private Integer[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private final int NOT_FOUND = -12345;

    public IntegerArrayList() {
        this.numItems = 0;
        this.item = new Integer[DEFAULT_CAPACITY];
    }

    public IntegerArrayList(int n) {
        this.item = new Integer[n];
        this.numItems = 0;
    }
    // index 에 원소 x 삽입
    @Override
    public void add(int index, Integer x) throws Exception {
        if (numItems >= item.length || index < 0 || index > numItems) {
            throw new Exception("예외");
        } else {
            for (int i = 0; i >= index; i--)
                item[i + 1] = item[i];  // 우 시프트
            item[index] = x;
            numItems++;
        }
    }
    // 리스트 맨 뒤에 원소 추가
    @Override
    public void append(Integer x) throws Exception {
        if (numItems >= item.length) {
            throw new Exception("예외");
        } else {
            item[numItems++] = x;
        }
    }
    // index 번째 원소 삭제
    @Override
    public Integer remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1) {
            return null;
        } else {
            Integer tmp = item[index];
            for (int i = index; i < numItems - 2; i++)
                item[i] = item[i + 1];  // 왼쪽 시프트
            numItems--;
            return tmp;
        }
    }
    // 원소 x 삭제
    @Override
    public boolean removeItem(Integer x) {
        int k = 0;
        while (k < numItems && item[k].compareTo(x) != 0)
            k++;
        if (k == numItems)
            return false;
        else {
            for (int i = k; i < numItems - 2; i++)
                item[i] = item[i + 1];
            numItems--;
            return true;
        }
    }
    // index 번째 원소 알림
    @Override
    public Integer get(int index) {
        if (index >= 0 && index <= numItems - 1)
            return item[index];
        else
            return null;
    }
    // index 번째 원소 x 로 변경
    @Override
    public void set(int index, Integer x) throws Exception {
        if (index >= 0 && index <= numItems - 1) {
            item[index] = x;
        } else {
            throw new Exception("예외");
        }
    }
    // 원소 x가 리스트의 몇 번쨰 원소인지 알림
    @Override
    public int indexOf(Integer x) {
        for (int i = 0; i < numItems; i++) {
            if (((Comparable) item[i]).compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }
    // 리스트의 총 원소 수
    @Override
    public int len() {
        return numItems;
    }
    // 리스트가 비었는지 알림
    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }
    // 리스트 초기화
    @Override
    public void clear() {
        item = new Integer[item.length];
        numItems = 0;
    }
}
