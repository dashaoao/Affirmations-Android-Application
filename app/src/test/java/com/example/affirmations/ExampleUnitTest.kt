package com.example.affirmations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.model.Affirmation
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import kotlin.random.Random

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    private val context = mock(Context::class.java)

    // 1. Тестирование инициализации ItemAdapter с пустым списком данных:

    @Test
    fun testEmptyDataset() {
        val context = mock(Context::class.java)
        val adapter = ItemAdapter(context, emptyList())
        assertNotNull(adapter)
    }

    // 2. Тестирование получения количества элементов в списке данных:

    @Test
    fun testGetItemCount() {
        val context = mock(Context::class.java)
        val dataset = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3)
        )
        val adapter = ItemAdapter(context, dataset)
        assertEquals(dataset.size, adapter.itemCount)
    }

    // 3. Тестирование выброса исключения при попытке получить элемент из пустого списка данных:

    @Test(expected = IndexOutOfBoundsException::class)
    fun testGetItemFromEmptyDataset() {
        val context = mock(Context::class.java)
        val adapter = ItemAdapter(context, emptyList())
        adapter.getItem(0)
    }

    // 4. Тестирование получения элемента в списке данных:

    @Test
    fun testGetItem() {
        val context = mock(Context::class.java)
        val dataset = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3)
        )
        val adapter = ItemAdapter(context, dataset)
        for (i in dataset.indices){
            assertEquals(dataset[i], adapter.getItem(i))
        }
    }

    // 5. Проверка отображения первого элемента:

    @Test
    fun testItemImage() {
        val dataset = mutableListOf(Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3))
        val adapter = ItemAdapter(context, dataset)
        val recyclerView = RecyclerView(context)
        recyclerView.adapter = adapter
        val randomIndex = Random.nextInt(dataset.size)
        recyclerView.scrollToPosition(randomIndex)
        val randomItemView = recyclerView.getChildAt(0)
        val imageView = randomItemView.findViewById<ImageView>(R.id.item_image)
        assertNotNull(imageView)
    }
}