package com.example.affirmations

import android.content.Context
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.model.Affirmation
import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*

class AdapterUnitTest {

    @Mock
    private lateinit var context: Context

    @Before
    fun setup() {
        context = Mockito.mock(Context::class.java)
    }

    // 1. Тестирование инициализации ItemAdapter с пустым списком данных:

    @Test
    fun testEmptyDataset() {
        val adapter = ItemAdapter(context, 1, emptyList())
        assertNotNull(adapter)
    }

    // 2. Тестирование получения количества элементов в списке данных:

    @Test
    fun testGetItemCount() {
        val dataset = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3)
        )
        val adapter = ItemAdapter(context, 1, dataset)
        assertEquals(dataset.size, adapter.itemCount)
    }

    // 3. Тестирование выброса исключения при попытке получить элемент из пустого списка данных:

    @Test(expected = IndexOutOfBoundsException::class)
    fun testGetItemFromEmptyDataset() {
        val adapter = ItemAdapter(context, 1, emptyList())
        adapter.getItem(0)
    }

    // 4. Тестирование получения элемента в списке данных:

    @Test
    fun testGetItem() {
        val dataset = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3)
        )
        val adapter = ItemAdapter(context,1, dataset)
        for (i in dataset.indices){
            assertEquals(dataset[i], adapter.getItem(i))
        }
    }

    // 5. Тестирование получения Id элемента в списке данных:

    @Test
    fun testGetItemId() {
        val dataset = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3)
        )
        val adapter = ItemAdapter(context, 1, dataset)

        assertEquals(R.string.affirmation1.toLong(), adapter.getItemId(0))
        assertEquals(R.string.affirmation2.toLong(), adapter.getItemId(1))
        assertEquals(R.string.affirmation3.toLong(), adapter.getItemId(2))
    }
}












