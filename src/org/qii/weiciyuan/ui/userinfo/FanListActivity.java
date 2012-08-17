package org.qii.weiciyuan.ui.userinfo;

import android.os.Bundle;
import org.qii.weiciyuan.R;
import org.qii.weiciyuan.bean.UserBean;
import org.qii.weiciyuan.ui.Abstract.AbstractAppActivity;
import org.qii.weiciyuan.ui.Abstract.IToken;
import org.qii.weiciyuan.ui.Abstract.IUserInfo;

/**
 * User: Jiang Qi
 * Date: 12-8-16
  */
public class FanListActivity extends AbstractAppActivity implements IUserInfo,
        IToken {
    private String token;

    private UserBean bean;

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public UserBean getUser() {
        return bean;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(getString(R.string.fan_list));
        token = getIntent().getStringExtra("token");
        bean = (UserBean) getIntent().getSerializableExtra("user");
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new FanListFragment(token, bean.getId()))
                .commit();

    }
}

