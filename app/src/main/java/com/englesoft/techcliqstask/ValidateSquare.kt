package com.englesoft.techcliqstask

import android.util.Log

object ValidateSquare {

    val arr = arrayOf(
        arrayOf(0, 0), arrayOf(2, 0), arrayOf(1, 1), arrayOf(0, -1), arrayOf(-1, -1),
        arrayOf(0, 2), arrayOf(0, 1), arrayOf(1, 0)
    )

    fun checkSquare(arr: Array<Array<Int>>): String {
        var result = ""
        for (i in 0..arr.size - 3) {
            for (j in i + 1 until arr.size - 2) {
                for (k in j + 1 until arr.size - 1) {
                    for (l in k + 1 until arr.size) {
                        result = if (validateSquare(arrayOf(arr[i], arr[j], arr[k], arr[l]))) {
                            Log.d("HelloLog", "checkSquare: ${arr[i]}${arr[j]}${arr[k]}${arr[l]}")
                            "${arr[i]}${arr[j]}${arr[k]}${arr[l]}"
                            break
                        } else
                            "Not found"
                    }
                }
            }
        }
        return result
    }

    private fun validateSquare(array: Array<Array<Int>>): Boolean {
        array.sortBy { it[0] }
        val p1 = array[0]
        val p2 = array[1]
        val p3 = array[2]
        val p4 = array[3]

        val distance = distanceBetweenTwoPoint(p1, p2)
        return if ((((p2[0] - p1[0]) * (p3[0] - p1[0]) + (p2[1] - p1[1]) * (p3[1] - p1[1])) != 0) || (distance==0)) {
            false
        } else {
            (distance == distanceBetweenTwoPoint(p1, p3)) && (distanceBetweenTwoPoint(
                p4,
                p2
            ) == distanceBetweenTwoPoint(p4, p3))
        }
    }

    private fun distanceBetweenTwoPoint(p1: Array<Int>, p2: Array<Int>): Int {
        return (p2[0] - p1[1]) * (p2[0] - p1[1]) + (p2[0] - p1[1]) * (p2[0] - p1[1])
    }
}