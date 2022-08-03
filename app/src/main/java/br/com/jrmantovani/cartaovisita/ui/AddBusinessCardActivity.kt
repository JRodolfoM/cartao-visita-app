package br.com.jrmantovani.cartaovisita.ui



import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.jrmantovani.cartaovisita.App
import br.com.jrmantovani.cartaovisita.R
import br.com.jrmantovani.cartaovisita.data.BusinessCard
import br.com.jrmantovani.cartaovisita.databinding.ActivityAddBusinessCardBinding


class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }
    var corPersonalizado = ""

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        insertListeners()
    }

    private fun insertListeners() {
        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = corPersonalizado
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }

        val colors = resources.getStringArray(R.array.colors) as Array<String>
        val adapter = ColorAdapter(this, R.layout.spinner_color, colors)
        binding.spinner2.adapter = adapter;
        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                corPersonalizado = adapter.getItem(position).toString()

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }



    }
}