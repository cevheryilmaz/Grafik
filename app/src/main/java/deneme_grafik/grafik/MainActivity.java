package deneme_grafik.grafik;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart piechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        piechart=(PieChart) findViewById(R.id.piechart);


        piechart.setUsePercentValues(true);
        piechart.getDescription().setEnabled(false);
        piechart.setExtraOffsets(5,10,5,5);

        piechart.setDragDecelerationFrictionCoef(0.95f);

        piechart.setDrawHoleEnabled(true);
        piechart.setHoleColor(Color.WHITE);
        piechart.setTransparentCircleRadius(60f);

        ArrayList<PieEntry> yvaluse =new ArrayList<>();

        yvaluse.add(new PieEntry(34f,"Fransa"));
        yvaluse.add(new PieEntry(23f,"Turkey"));
        yvaluse.add(new PieEntry(14f,"Russia"));
        yvaluse.add(new PieEntry(35,"İndia"));
        yvaluse.add(new PieEntry(40,"Japan"));
        yvaluse.add(new PieEntry(23,"England "));


        Description description=new Description();
        description.setText("Bu Bir Grafik Uygulamasıdır  ");
        description.setTextSize(25);
        piechart.setDescription(description);

        piechart.animateY(1000, Easing.EasingOption.EaseInCubic);

        PieDataSet dataSet=new PieDataSet(yvaluse,"Countries");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data=new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        piechart.setData(data);

    }
}
