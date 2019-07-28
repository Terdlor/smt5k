package com.example.smt5k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.smt5k.bd.HelperFactory
import com.example.smt5k.bd.model.TimeTemp
import com.example.smt5k.bd.model.TimeTempDAO
import com.example.smt5k.common.getNormalDateString
import com.example.smt5k.common.toast
import kotlinx.android.synthetic.main.activity_start.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        b1.setOnClickListener(this::onClick)
        b2.setOnClickListener(this::onClick2)


        HelperFactory.setHelper(getApplicationContext());

        updateView()
    }

    private fun onClick(view: View){
        val date : Date = GregorianCalendar().time
        var string : String = getNormalDateString(date)
        toast(this, string)
        t1.text = string
        saveTime(date)
        updateView()
    }

    fun updateView(){
        var list : List<TimeTemp> = getData()
        var iter :Iterator<TimeTemp> = list.iterator()
        var strList : String = ""
        while (iter.hasNext()){
            var item :TimeTemp = iter.next()
            var data : Date = item.date
            strList += getNormalDateString(data)+"\n"
        }
        t2.text = strList
    }

    fun onClick2(view: View){
        val timeTempDao : TimeTempDAO = HelperFactory.getHelper().getTimeTempDAO()
        timeTempDao.clearTable()
        updateView()
    }

    fun saveTime(date: Date){
        val timeTempDao : TimeTempDAO = HelperFactory.getHelper().getTimeTempDAO()
        timeTempDao.create(TimeTemp(date))
    }

    fun getData():List<TimeTemp>{
        val timeTempDao : TimeTempDAO = HelperFactory.getHelper().getTimeTempDAO()
        return timeTempDao.all;
    }

    override fun onDestroy() {
        super.onDestroy()
        HelperFactory.releaseHelper()
    }
}
