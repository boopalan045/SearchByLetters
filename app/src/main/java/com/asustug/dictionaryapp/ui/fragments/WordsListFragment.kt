package com.asustug.dictionaryapp.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asustug.dictionaryapp.R
import com.asustug.dictionaryapp.databinding.FragmentWordsListBinding
import com.asustug.dictionaryapp.ui.adapter.LetterAdapter
import com.asustug.dictionaryapp.ui.adapter.WordAdapter

class WordsListFragment : Fragment() {

    private var _binding : FragmentWordsListBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private var isLinearLayoutManager = true

    private lateinit var letterId: String

    companion object {
        val LETTER = "letter"
        val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordsListBinding.inflate(inflater, container,false)
        val view =binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val recyclerView = binding.rvFragmentWordsList
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WordAdapter(letterId, requireContext())

        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}