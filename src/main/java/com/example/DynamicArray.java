package com.example;

import java.util.Arrays;

public class DynamicArray {
    private int[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 4;

    public DynamicArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * 在 index 下标处插入元素 value
     * 如果 index 的值超过当前数组中元素个数（即大于len），返回 false，否则返回 true
     *
     * @param index 插入位置下标
     * @param value 插入的值
     * @return 是否插入成功
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > size) {
            return false;
        }

        // 检查是否需要扩容
        if (size == data.length) {
            resize();
        }

        // 将 index 及之后的元素向后移动一位
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
        return true;
    }

    /**
     * 删除下标为 index 的元素
     * 如果 index 值超出数组下标范围 [0, len)，返回-1，否则，返回被删除元素值。
     *
     * @param index 删除位置下标
     * @return 被删除的元素值或 -1
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        int removedValue = data[index];

        // 将 index 之后的元素向前移动一位
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return removedValue;
    }

    /**
     * 按照下标 index 查找元素
     * 如果下标 index 超出数组下标范围 [0, len)，返回-1，否则，返回被查找元素值。
     *
     * @param index 查找位置下标
     * @return 查找到的元素值或 -1
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return data[index];
    }

    /**
     * 获取当前数组元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 获取当前数组容量 (仅用于测试验证)
     */
    public int capacity() {
        return data.length;
    }

    private void resize() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }
}
