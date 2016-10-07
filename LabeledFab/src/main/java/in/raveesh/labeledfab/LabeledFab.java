package in.raveesh.labeledfab;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Raveesh on 07/10/16.
 */

public class LabeledFab extends RelativeLayout {
    @IntDef({Position.LEFT, Position.TOP, Position.RIGHT, Position.BOTTOM})
    private @interface Position{
        int LEFT = 0;
        int TOP = 1;
        int RIGHT = 2;
        int BOTTOM = 3;
    }

    private int labelPosition;
    private String label;
    private float labelMargin;
    private float labelPadding;
    @DrawableRes private int icon;

    private TextView text;
    private FloatingActionButton fab;

    public LabeledFab(Context context) {
        super(context);
    }

    public LabeledFab(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.LabeledFab,
                0, 0);

        try {
            labelPosition = a.getInt(R.styleable.LabeledFab_tooltipSide, 0);
            labelMargin = a.getDimension(R.styleable.LabeledFab_labelMargin, getResources().getDimension(R.dimen.default_label_margin));
            labelPadding = a.getDimension(R.styleable.LabeledFab_labelPadding, getResources().getDimension(R.dimen.default_label_padding));
            icon = a.getResourceId(R.styleable.LabeledFab_labelIcon, -1);
            label = a.getString(R.styleable.LabeledFab_labelText);
            if (label == null){
                label = getContentDescription().toString();
            }
        } finally {
            a.recycle();
        }
        inflate();
    }

    private void inflate(){
        LayoutInflater.from(getContext()).inflate(getLayout(), this, true);
        text = (TextView) findViewById(R.id.text);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(icon);
        fab.setContentDescription(label);
        text.setText(label);
    }

    private @LayoutRes int getLayout(){
        switch (labelPosition) {
            case Position.RIGHT: return R.layout.labeled_fab_right;
            case Position.TOP: return R.layout.labeled_fab_top;
            case Position.BOTTOM: return R.layout.labeled_fab_bottom;
            case Position.LEFT:
            default:return R.layout.labeled_fab_left;
        }
    }
}
