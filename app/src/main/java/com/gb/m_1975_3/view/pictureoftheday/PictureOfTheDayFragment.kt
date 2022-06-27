package com.gb.m_1975_3.view.pictureoftheday

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BulletSpan
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.m_1975_3.R
import com.gb.m_1975_3.databinding.FragmentPictureOfTheDayBinding
import com.gb.m_1975_3.utils.Parameters
import com.gb.m_1975_3.view.MainActivity
import com.gb.m_1975_3.view.settings.SettingsFragment
import com.gb.m_1975_3.viewmodel.AppState
import com.gb.m_1975_3.viewmodel.PictureOfTheDayViewModel
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior


class PictureOfTheDayFragment : Fragment() {


    var isMain = true

    private var _binding: FragmentPictureOfTheDayBinding? = null
    private val binding: FragmentPictureOfTheDayBinding
        get() {
            return _binding!!
        }

    val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_fav -> Toast.makeText(context, "Favourite", Toast.LENGTH_SHORT).show()
            R.id.app_bar_settings -> requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, SettingsFragment.newInstance()).addToBackStack("").commit()
            android.R.id.home -> {
                BottomNavigationDrawerFragment().show(requireActivity().supportFragmentManager, "")
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        (requireActivity() as MainActivity).setSupportActionBar(binding.bottomAppBar)
        viewModel.getLiveDataForViewToObserve().observe(viewLifecycleOwner) {
            renderData(it)
        }
        viewModel.sendServerRequest()

        binding.inputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            })
        }

        val params =
            (binding.lifeHack.bottomSheetContainer.layoutParams as CoordinatorLayout.LayoutParams)
        val behavior = params.behavior as BottomSheetBehavior
        behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        behavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    /*   BottomSheetBehavior.STATE_DRAGGING -> TODO("not implemented")
                       BottomSheetBehavior.STATE_COLLAPSED -> TODO("not implemented")
                       BottomSheetBehavior.STATE_EXPANDED -> TODO("not implemented")
                       BottomSheetBehavior.STATE_HALF_EXPANDED -> TODO("not implemented")
                       BottomSheetBehavior.STATE_HIDDEN -> TODO("not implemented")
                       BottomSheetBehavior.STATE_SETTLING -> TODO("not implemented")*/
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("@@@", "$slideOffset slideOffset")
            }

        })

        binding.fab.setOnClickListener {
            //requireActivity().setTheme(R.style.MyGreenTheme)
            Parameters.getInstance().theme = R.style.MyGreenTheme // TODO HW SharedPref
            requireActivity().recreate()
            isMain = !isMain
            if (!isMain) {
                binding.bottomAppBar.navigationIcon = null
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_back_fab
                    )
                )
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar_other)
            } else {
                binding.bottomAppBar.navigationIcon =
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_hamburger_menu_bottom_bar
                    )
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                binding.fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_plus_fab
                    )
                )
                binding.bottomAppBar.replaceMenu(R.menu.menu_bottom_bar)
            }
        }


    }

    @SuppressLint("NewApi") // TODO HW обязательно УПАДЕТ НА всех версиях ниже 28
    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {/*TODO HW*/
            }
            is AppState.Loading -> {/*TODO HW*/
            }
            is AppState.Success -> {
                binding.imageView.load(appState.serverResponseData.hdurl) {
                    placeholder(R.drawable.giphy)
                    error(R.drawable.ic_load_error_vector)
                    crossfade(true)
                }
                binding.lifeHack.title.text = appState.serverResponseData.title
                binding.lifeHack.explanation.text = appState.serverResponseData.explanation
                /*binding.lifeHack.explanation.typeface = Typeface.createFromAsset(requireActivity().assets,
                    "layer1/layer2/folder1/folder2/AZERET.ttf")*/


                val text = "My text \nbullet one \nbullet two \nbulleretdfhrtjhtht two\nbullet twtykjytko \nbullerettht twtyjktyo\nbullet twtyko \nbullertrhjtrjettht two\nbulleretdfhrtjhtht two\nbullet twtykjytko \nbullerettht twtyjktyo\nbullet twtyko \nbullertrhjtrjettht two\nbulleretdfhrtjhtht two\nbullet twtykjytko \nbullerettht twtyjktyo\nbullet twtyko \nbullertrhjtrjettht two\nbulleretdfhrtjhtht two\nbullet twtykjytko \nbullerettht twtyjktyo\nbullet twtyko \nbullertrhjtrjettht two"
                val spannableString = SpannableString(text)
                val list = text.indexesOf("\n")

                var current = 0
                list.forEach {
                    spannableString.setSpan(
                        BulletSpan(
                            20,
                            ContextCompat.getColor(requireContext(), R.color.colorAccent),
                            20
                        ), current, it, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    current = it+1
                }

                //binding.lifeHack.explanation.text = Html.fromHtml(text,Html.FROM_HTML_MODE_COMPACT)



                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    spannableString.setSpan(
                        BulletSpan(
                            20,
                            ContextCompat.getColor(requireContext(), R.color.colorAccent),
                            20
                        ), 9, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    spannableString.setSpan(
                        BulletSpan(
                            20,
                            ContextCompat.getColor(requireContext(), R.color.colorAccent),
                            20
                        ), 21, spannableString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                } else {
                    spannableString.setSpan(
                        BulletSpan(
                            20,
                            ContextCompat.getColor(requireContext(), R.color.colorAccent)
                        ), 8, 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
                binding.lifeHack.explanation.text = spannableString
            }
        }
    }

    fun String.indexesOf(substr: String, ignoreCase: Boolean = true): List<Int> =
        (if (ignoreCase) Regex(substr, RegexOption.IGNORE_CASE) else Regex(substr))
            .findAll(this).map { it.range.first }.toList()


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PictureOfTheDayFragment()
    }
}