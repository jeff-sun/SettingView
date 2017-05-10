## SettingView
### 现在市面上许多应用在个人中心或者设置中心都有条目,每次都会写这些无用的代码,所以做了一个简单的组合控件,简单省时,方便开发.
先上图<br>
![](https://github.com/jeff-sun/SettingView/raw/master/demo.jpg)<br>
<h3>快速使用</h3>
<h5>1.添加依赖</h5><pre><code>compile 'com.jeff:settingitem:1.0'
</code></pre>
<h5>2.在布局文件中引用</h5>
<pre><code>&lt;com.jeff.settingitem.SettingView
        android:layout_width="match_parent"
        android:layout_height="44dp"
        app:item_background="@drawable/selector_item"
        app:item_text="消息"
        app:left_icon="@mipmap/icon_per_infor"
        app:show_dot="true"
        app:text_size="16sp" /&gt;
</code></pre>
<h5>3.添加点击事件<h5>
<pre><code>SettingView mItem = (SettingView) findViewById(R.id.setting);
        mItem.setOnItemViewClick(new SettingView.OnItemViewClick() {
            @Override
            public void itemClick() {
                //do something
            }
        });
</code></pre>
<h5>4.对外提供设置方法<h5>
<pre><code>mItem.setItemText("消息");    //设置条目文字
mItem.showDot(false);       //是否显示红点
mItem.showRightIcon(true);      //是否显示右边icon
mItem.showLeftIcon(true);       //是否显示左边icon</code></pre>
<h5>5.xml中的自定义属性<h5>
<table>
<thead>
<tr>
<th>属性</th>
<th>说明</th>
<th>类型</th>
</tr>
</thead>
<tbody>
<tr>
<td>item_text</td>
<td>条目文字</td>
<td>string</td>
</tr>
<tr>
<td>item_background</td>
<td>条目背景</td>
<td>reference</td>
</tr>
<tr>
<td>left_icon</td>
<td>左侧图标</td>
<td>reference</td>
</tr>
<tr>
<td>right_icon</td>
<td>右侧图标</td>
<td>reference</td>
</tr>
<tr>
<td>text_size</td>
<td>文字大小</td>
<td>dimension</td>
</tr>
<tr>
<td>text_color</td>
<td>文字颜色</td>
<td>color</td>
</tr>
<tr>
<td>show_left_icon</td>
<td>是否显示左侧图标(默认显示)</td>
<td>boolean</td>
</tr>
<tr>
<td>show_right_icon</td>
<td>是否显示右侧图标(默认显示)</td>
<td>boolean</td>
</tr>
<tr>
<td>show_dot</td>
<td>是否显示小红点(默认不显示)</td>
<td>boolean</td>
</tr>
<tr>
<td>left_icon_margin_left</td>
<td>左侧图标距离左边margin</td>
<td>dimension</td>
</tr>
<tr>
<td>text_margin_left</td>
<td>文字距离左边margin</td>
<td>dimension</td>
</tr>
<tr>
<td>right_icon_margin_right</td>
<td>右侧图标距离右边margin</td>
<td>dimension</td>
</tr>
</tbody></table>
<hr>
<p>欢迎大家star,有什么问题可以issue.欢迎访问我的<a href="http://www.jianshu.com/u/3c128613a202/">博客</a> 查看更多文章。</p>
