package com.example.ampa_lab_5

class DataRepo
{
    val LIST_SIZE = 15
    val item_text_list = Array(LIST_SIZE) { i -> "Item name " +i}

    private lateinit var dataList: MutableList<DataItem>

    companion object{
        private var INSTANCE: DataRepo? = null
        fun getinstance(): DataRepo {
            if (INSTANCE == null){
                INSTANCE = DataRepo()
            }
            return INSTANCE as DataRepo
        }
    }
    fun getData(): MutableList<DataItem> {
        return dataList
    }
    fun deleteItem(pos: Int): Boolean {
        if (pos < dataList.size-1) {
            dataList.removeAt(pos)
            return true
        }
        return false
    }
    init {
        dataList = mutableListOf(DataItem(1), DataItem(2), DataItem(3), DataItem(4), DataItem(5), DataItem(6), DataItem(7), DataItem(8), DataItem(9), DataItem(10))
    }
}