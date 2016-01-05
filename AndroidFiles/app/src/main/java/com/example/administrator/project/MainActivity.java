package com.example.administrator.project;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2015/12/5.
 */
public class MainActivity  extends Activity{

    ImageView imageView;
    Button row1col1;
    Button row1col2;
    Button row2col1;
    Button row2col2;
    Button row2col3;
    Button row3col1;
    Button row3col2;
    Intent to_login;
    Intent to_logout;
    Intent to_change;
    public static  int if_login = 0;
    public  static int  width ;
    public  static int height;

    public SQLiteDatabase database;
    public static  MyDatabaseHelper myDatabaseHelper;
    public Contact contact1,contact2,contact3;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        //本地数据库
        myDatabaseHelper = new MyDatabaseHelper(MainActivity.this);
        initDatabase();

        to_change = new Intent(this,GerenxinxiActivity.class);
        to_login = new Intent(this,LoginActivity.class);
        to_logout = new Intent(this,LoginOutActivity.class);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels;
        height = metric.heightPixels;
        imageView = (ImageView)findViewById(R.id.Picture);
        LayoutParams para;
        para = imageView.getLayoutParams();
        para.height = height / 4;
        para.width = width;
        imageView.setLayoutParams(para);

        row1col1 = (Button)findViewById(R.id.row1col1);
        LayoutParams para1;
        para1 = row1col1.getLayoutParams();
        para1.height = height / 4;
        para1.width = width/4;
        row1col1.setLayoutParams(para1);
        row1col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Row1Col1Activity.class);
                startActivity(intent);
            }
        });

        row1col2 = (Button)findViewById(R.id.row1col2);
        LayoutParams para2;
        para2 = row1col2.getLayoutParams();
        para2.height = height / 4;
        para2.width = width/2;
        row1col2.setLayoutParams(para2);

        row1col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Row1Col2Activity.class);
                startActivity(intent);
            }
        });

        row2col1 = (Button)findViewById(R.id.row2col1);
        LayoutParams para3;
        para3 = row2col1.getLayoutParams();
        para3.height = height / 4;
        para3.width = width/5 * 2;
        row2col1.setLayoutParams(para3);

        row2col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Row2Col1Activity.class);
                startActivity(intent);
            }
        });

        row2col2 = (Button)findViewById(R.id.row2col2);
        LayoutParams para4;
        para4 = row2col2.getLayoutParams();
        para4.height = height / 4;
        para4.width = width/10 *3;
        row2col2.setLayoutParams(para4);

        row2col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Row2Col2Activity.class);
                startActivity(intent);
            }
        });

        row2col3 = (Button)findViewById(R.id.row2col3);
        LayoutParams para5;
        para5 = row2col3.getLayoutParams();
        para5.height = height / 4;
        para5.width = width/10 *3;
        row2col3.setLayoutParams(para5);

        row2col3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Row2Col3Activity.class);
                startActivity(intent);
            }
        });

        row3col1 = (Button)findViewById(R.id.row3col1);
        LayoutParams para6;
        para6 = row3col1.getLayoutParams();
        para6.height = height / 5;
        para6.width = width/2;
        row3col1.setLayoutParams(para6);

        row3col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Row3Col1Activity.class);
                startActivity(intent);
            }
        });

        row3col2 = (Button)findViewById(R.id.row3col2);
        LayoutParams para7;
        para7 = row3col2.getLayoutParams();
        para7.height = height / 5;
        para7.width = width/4;
        row3col2.setLayoutParams(para7);

        row3col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Row3Col2Activity.class);
                startActivity(intent);
            }
        });
    }
    public void  initDatabase()
    {
        int result = myDatabaseHelper.empty();
        if(result == 1) {
            contact1 = new Contact("数据库修改时间:2015.12.31", "标题:气候指导", " 随季节变化会出现太阳直射的现象，各个季节的温度差异不大，气象主要受到干湿情况和季风的影响。  折叠编辑本段季节特性  中国人认为四季有不同的特性，分别是\"春生\"、\"夏长\"、\"秋收\"和\"冬藏\"。即万物在春天出生、在夏天成长、在秋天收成(成熟)和在冬天藏起来(动物冬眠、植物落叶)。  折叠编辑本段季节减肥  折叠春天减肥方法  每日减肥，从早餐开始  春季减肥在饮食上是至关重要的，而早餐也是一天中最重要的一餐。酸奶对瘦身和健康都有非常大的帮助，所以每天早餐一杯酸奶一定要喝哦!不喜欢喝酸奶的朋友可以在早餐选用番茄汁或者胡萝卜汁，这些都是有助于新陈代谢的饮品哦!  饭前吃水果，轻松甩油脂  常言道:想瘦身，饭前果。这是有一定的科学医据的，吃饭水果有助于肠胃蠕动速度，吃掉的食物可以充分在胃肠中消化干净，当然不易发胖。  睡前4小时，不进食  人在休眠状态下新陈代谢能力下降，胃肠蠕动率降低，食物容易推挤在腹中，不仅影响消化功能，还容易增加腹部赘肉，春季减肥的常识中可是重中之重。除此之外，睡前2小时也不建议大量喝水。  折叠夏天减肥方法  少食多餐  每顿饭少吃点儿，一天多吃几次。也许这样会有点儿耽搁时间，但是它会促进你的肠胃蠕动，充分地分解食物，吸收营养。要知道人体的分解机能开始运转也需要消耗大量的热量。相对于那些每天只吃一两顿饭，但是每次都吃得很撑的人，少吃多餐的确健康得多，而且消耗的热量也会更多一些。相关推荐:少食多餐减肥食谱  不要错过早餐  要减肥就不能不吃早餐，不吃早餐很容易在中午或者晚上的时候控制不住自己的嘴，然后一下子就吃多了，比吃早餐的时候摄取的热量还要多。在青少年中，不吃早餐的孩子BMI值通常会比较高，容易引起肥胖。早餐吃什么减肥你知道吗?  每天要喝8杯水  要想瘦就要让自己尽可能多的多消耗热量。与此同时，身体也在不断地消耗水分。因此你需要保持身体液态平衡，吸收和利用好摄入的水分。如何喝水减肥?每天喝8杯水(也就是差不多两升)可以帮助你一天多消耗100卡路里。听上去这个量并不多，但是算算看一个星期就是700卡路里，一个月就是2800卡路里。而且身体里的水分充足还有助于让我们的肝和肾更加健康，让因为缺水而导致上火的可能性降低。  折叠秋天减肥方法  秋天有效快速运动减肥方法一、跑步  跑步是最基本也最有效的有氧运动之一，尤其在秋高气爽的季节里去户外跑步，我们的心情也会变得更加愉悦，而且压力也会得到很好的释放。对于减肥来说，慢跑是最适合的方式，因为它可以让我们体内的脂肪得到更充分的燃烧，并且不易对身体造成伤害，每次坚持跑步三十分钟以上，你会发现自己很快就瘦了下来。跑步的地点选择也很重要，我们应该尽量在树木比较多的公园或者是林荫小路上跑步，这样能够吸收更多的养分，避免在粉尘和尾气比较多的马路上跑步。  秋天有效快速运动减肥方法二、跳绳  跳绳是一个不受地点限制的超强有氧运动，它的运动强度甚至比慢跑还要大，跳绳可以锻炼到全身的肌肉，减少腿部、腹部以及手臂上的顽固脂肪。跳绳也非常的具有趣味性，我们既可以和别人进行比赛，同时也能和自己比赛，在规定的时间内计算自己的跳绳次数，也是一种很不错的挑战方式。  秋天有效快速运动减肥方法三、跳舞  跳舞是一种非常有效的燃脂运动，而且还带有很大的娱乐性，同时也能让我们的体态和身形变得更加完美。经常跳舞的人新陈代谢也比较旺盛，甚至会逐渐的过度到易瘦体质。跳舞的方式有很多种，我们可以根据自己的兴趣来进行选择，无论是性感的肚皮舞还是优雅的芭蕾舞，或者是充满异国情调的拉丁舞，都能把我们带入非常快乐的舞蹈世界里，塑造完美的身材。  秋天有效快速运动减肥方法四、呼啦圈  呼啦圈也是一种非常简单的运动方式，我们平时在家就可以进行，尤其对于大家最烦恼的游泳圈来说，摇呼啦圈是非常好的减肥方式。我们需要知道的是，摇呼啦圈的运动强度相对较低，所以每次至少要晃半个小时以上才能起到减少小肚子的效果，而且一旦停下来也比较容易反弹，所以每天都要坚持，另外摇呼啦圈对腹部也是一种很好的按摩，可以起到解决便秘的作用。  折叠冬天减肥方法  寒冷的冬季想要减肥又不想出门，那么就做家务吧，做家务也是一种很棒的冬季减肥方法。  在做家务的时候要有意识的用自己的力量去运动，没事就擦擦窗户擦擦桌椅，如果可以的话拖地也要用抹布手拖，这样加大了运动量，让更多脂肪在身体里燃烧起到减肥效果。  冬天最适合早上洗澡，因为早上起床后是人体新陈代谢很快的时期，在这个时候又去冲热水洗澡按摩就能够让脂肪更加快速的被分解。可以的话就尝试用粗盐加入温水调成膏状，然后涂抹在腹部进行按摩，这样可以发汗，排除身体里的毒素，促进皮肤和身体的新陈代谢，让松垮垮的腹部皮肤变得更加紧致  在家里看电视无聊的时候可以一边做瑜伽一边看，这样不仅时间过得快还能够让你坚持更长的时间，燃脂效果更好，下面就介绍给大家一个简单的瘦身瑜伽动作，想要瘦的MM赶快来学习了。  平躺在瑜伽垫上，双腿打开和肩膀一样的宽度，膝盖弯曲脚板踩在垫子上，慢慢的吐气，用腹部的力量将身体慢慢的抬起来形成拱桥的形状;将手放在腰部的地方手肘贴地的撑着，注意收紧腹部，将左腿抬起来往上踢，然后换右腿继续，一共踢30次休息.");
            contact2 = new Contact("数据库修改时间:2015.12.31", "标题:出行指导", "纪律一：防寒保暖是首要任务 冬季的旅游线路，特别是赏雪玩雪的线路，一般都会在北方地区，而北方冬天的气温大抵于0度--30度，有的地方甚至是低于30度，年以对于南方市民来说，防寒保暖是最重要的。 纪律二：备用药品不可少 冬季天气寒冷，容易得感冒，所以出门，要记得预备羚羊感冒片等易于携带、治疗伤风感冒的药品。另外北方地区爱吃凉菜，不习惯者易“闹肚子”，需备上黄莲片、保济丸等药片。北方地区气候干燥、南方体质的市民还需准备夏难能可桑菊、王老吉等清热冲剂。 纪律三：保湿不能掉以轻心 北方地区的保湿是很多游客都会忽视的问题，很多南方游客到了哈尔滨等北方地区之后，就会流鼻血，他们大多都会不解。原来是干燥惹的祸，以哈尔滨为例，一般的空气湿度都是在20%左右，跟南方地区动辄80%-90%的湿度比起来，相差太大了。如果没有喝上足够的水，会导致毛细血管破裂而引流鼻血。 注意防滑 冬季北方路面多有冰雪，路面较滑，穿塑料底的鞋容易滑倒。最好穿橡胶鞋底的雪地防滑棉鞋或球鞋，尽量不要穿皮鞋，否则行动不便。 在往年的许多例子中，老人家应该是重点防滑的对象，所以经验丰富的导游，都会对长者多加提醒。另外，“寒从脚下起”，从保暖的角度讲，鞋也是重要的一环，一双轻巧而保暖的鞋子是征占冬季旅游的必备“武器”。 注意相机保暖 电子快门的照相机和摄影机，在-20度以下时，就会出现电池容易“放电”、快门不能按下等相机“失灵”的问题，因此，在户外拍摄完之后，要及时将相机放进外衣兜里“保暖”，用时再拿出来。 此外，提醒一句，一定要多准备电池。 注意防雪盲 北方冬季多下雪，雪的反光比较大，出门需要佩戴太阳镜，保护眼睛。如果不幸患上雪盲证的话，治疗的办法是立刻到黑暗的地方，蒙住双眼，把冰湿布放到额前，防止高温加剧疼痛，一段时间后让眼睛慢慢恢复。 注意滑雪安全 对于滑雪这种速度快、灵敏性强的全身运动，无论是初学者还是有高超技术的人，运动前都必须做好准备活动。游客应选择安全防护设施齐全的滑雪场，并将个人防护设备配备齐全，遵守滑雪场的规章制度，进入与自己滑雪水平相当的滑道。只有当滑雪者的技术水平达到能安全地停住，并能避开滑雪道上的障碍物和其他滑雪者时，才能动较高水准的雪场滑雪。滑雪前应学习一些基本的医学知识和急救常识，如受伤时的处理，骨折后应采取的措施等。发现他人受伤，千万不要手忙脚乱随意处置和搬动，应尽快向雪场救护人员报告。 注意温泉细节 如果温泉水温过高，人从温度较低的空气中骤然浸入泉水里，一般很难适应。所以要先用手或脚试探水温是否合适，再进入温泉泳池，并应该从低温泉到高温泉，逐步适应。泡温泉每次为20到30分钟。如果一次浸泡的时间过长，容易出现晕眩、全身乏力。当您在泉水中感觉口干、胸闷时，应该上池边休息，喝点饮料补充水分。温泉浴是一种中等强度的运动，在令身心得到全面放松的同时，灵敏度和注意力也会有所下降。所以，驾车人士在泡过温泉后，一定要休息两个小时以上方可驾车。 注意酒保暖 冬季旅游者的膳食中，蛋白质、碳水化合物和脂肪三项营养素以及矿物质、维生素的摄取量都要超过平常，不能像平时一样过分的强调限制脂肪和碳水化合的摄取量，要纠正画龙点睛喝酒取暖的错误观念。酒精和水不能产生热量，相反，会使体表血液循环增加，当人体感到“发热”，实际上是在丢失热量。 注意防抢防盗 冬季接近年关，而且处于客流出行高峰期，也成为了偷盗等犯罪行为的高发期，游客应注意保管好自身财物，提高防盗的保护意识。");
            contact3 = new Contact("数据库修改时间:2015.12.31", "标题:季节信息", "季节更迭的根本原因是地球的自转轴与其公转轨道平面不垂直，偏离的角度是23度26分(黄赤交角)。在不同的季节，南北半球所受到的太阳光照不相等，日照更多的半球是夏季，另一半是冬季。春季和秋季则为过渡季节，当太阳直射点接近赤道时，两个半球的日照情况相当，但是季节发展的趋势却还是相反--当南半球是秋季时，北半球是春季。  天文季节划分法严格按照地球公转位置来决定，而实际的季节不同地区因气候而异。划分四季的方法很多，以下四种为最常见的(以北半球为例):  中国传统以四立为划分四季的起点，立春就是春季的起点，等等。 西方以二分二至为划分四季的起点，春分是春季的起点，等等。 以气候本身的标准──候温(五日的平均气温)划分 夏季──候平均气温在22 °C以上的连续时期。 冬季──候平均气温在10 °C以下的连续时期。 春季和秋季──介于10 ~22 °C之间的时期。  按照以上观点，全球共存在6种季节组合类型:  全年皆夏(全年各月平均气温都在22 °C以上，主要分布于赤道附近地区); 全年皆冬(全年各月平均气温都在10 °C以下，主要分布于两极地区); 长夏无冬(全年不存在平均气温在10 °C以下的月份，主要分布在南北回归线附近); 长冬无夏(全年不存在平均气温在22 °C以上的月份，主要分布在南北极圈附近); 四季分明(主要分布于中纬度地区的大陆上，以中国长江流域中下游地区最为典型); 四季如春(全年各月平均气温都在10 ~22 °C之间，主要分布于低纬度的高原地区，以及中纬度地区的海洋上)。 现今通用以天文季节与气候季节相结合来划分四季。 即3、4、5月为春季，6、7、8月为夏季，9、10、11月为秋季，12、1、2月为冬季。  折叠编辑本段天文季节  以天文因子为依据划分的季节。由于地球的自转轴倾斜于它绕太阳公转的轨道面(即黄道面)，地球表面的太阳辐射量的变化，呈规律性地每年循环一次。每年相同的月份，各地大体上出现各固有的气候特征。在温带地区，通常把接受太阳辐射最多，即最炎热的时段称为夏季，接受太阳辐射最少，即最寒冷的时段称为冬季,它们之间的过渡时段称为春季和秋季。如:在北半球的温带地区，一般3~5月为春季，6~8月为夏季，9~11月为秋季，12月至次年2月为冬季。南半球温带地区，则9~11月为春季，12月至次年 2月为夏季，3~5月为秋季，6~8月为冬季。中国古代多以立春、立夏、立秋、立冬为四季的开始，而欧洲和北美洲的很多国家则以春分、夏至、秋分、冬至作为四季的初日。天文季节虽然有气候意义，却没有把地理和天气的因素考虑在内。  折叠编辑本段气候季节  以气候要素的分布状况为依据划分的季节。中国的气候季节最早是由张宝汗(1934)研究的。他在《中国四季之分配》一文中，提出以候(五天)平均气温低于10C为冬季，高于22C为夏季，10~22C之间为春秋过渡季，并划出各地四季的长短。由于10C以上适合于大部分农作物生长，一年中维持在10C以上的时间的长短对农业生产的影响很大，所以这样划分季节,有很大的实际意义。  除温带的四季外，其他气候带因其气候的特殊性，常采用其他气候要素划分气候季节。在热带和一些亚热带地区，气温的年变化较小，常用降水量或风向的变化来划分季节，故有干季和雨季;东北信风季和西南信风季等。这种划分季节的方法，在南亚次大陆尤为通用。在北非大部分地区，把一年划分为凉季、热季和雨季三个季节。在极地附近，则按日照的状况划分为永昼的夏季和长夜的冬季两个季节。  在地势高亢的青藏高原，冬半年干旱、多大风，夏半年多降水，故全年大体可分为风季(干季)和雨季两个季节。对下垫面不同的其他地区，如海洋和内陆，森林和草原，都因气候不同，而可采取不同的划分季节的标准，以适应当地的生产和生活的需要。  自然天气季节:上述的季节划分法，都没有把天气因素考虑在内，因此大多不适合于研究季节的年际变化。20世纪20年代，苏联气候学家..穆利塔诺夫斯基首先提出了自然天气季节的概念，他以形成气候的天气过程的特点来划分季节,将苏联的欧洲部分,一年分为春、夏、秋、前冬和冬五个季节。后来C.T.帕加瓦又将夏季再划分为初夏和盛夏两季。中国杨初等在50年代根据 500百帕环流型，研究了东亚的自然天气季节。自然天气季节的划分法是天气气候学的研究内容之一，对长期天气预报工作有重要意义。但由于天气过程的复杂性，目前还缺少划分自然天气季节的客观的或统一的标准。因此，季节的起止日期，也不容易确定。同时，对某种自然天气季节区，由于地点不同，受到天气系统的影响也不同，因而天气表现也不一样。所以自然天气季节的概念，尚未成熟，有待于进一步的研究。  折叠编辑本段热量差异的季相特征  在不同的纬度带内，季节变化具有不同的特征。在南北半球的相对气候带，季节也相对:秋季对春季，夏季对冬季。  折叠温带  亚热带的四季分明。  折叠寒带  寒带终年寒冷，但是在夏季和冬季的气温差别还是很明显的。 在夏季和冬季会出现极昼、极夜的现象。  折叠热带  随季节变化会出现太阳直射的现象，各个季节的温度差异不大，气象主要受到干湿情况和季风的影响。  折叠编辑本段季节特性  中国人认为四季有不同的特性，分别是\"春生\"、\"夏长\"、\"秋收\"和\"冬藏\"。即万物在春天出生、在夏天成长、在秋天收成(成熟)和在冬天藏起来(动物冬眠、植物落叶)。  折叠编辑本段季节减肥  折叠春天减肥方法  每日减肥，从早餐开始  春季减肥在饮食上是至关重要的，而早餐也是一天中最重要的一餐。酸奶对瘦身和健康都有非常大的帮助，所以每天早餐一杯酸奶一定要喝哦!不喜欢喝酸奶的朋友可以在早餐选用番茄汁或者胡萝卜汁，这些都是有助于新陈代谢的饮品哦!  饭前吃水果，轻松甩油脂  常言道:想瘦身，饭前果。这是有一定的科学医据的，吃饭水果有助于肠胃蠕动速度，吃掉的食物可以充分在胃肠中消化干净，当然不易发胖。  睡前4小时，不进食  人在休眠状态下新陈代谢能力下降，胃肠蠕动率降低，食物容易推挤在腹中，不仅影响消化功能，还容易增加腹部赘肉，春季减肥的常识中可是重中之重。除此之外，睡前2小时也不建议大量喝水。  折叠夏天减肥方法  少食多餐  每顿饭少吃点儿，一天多吃几次。也许这样会有点儿耽搁时间，但是它会促进你的肠胃蠕动，充分地分解食物，吸收营养。要知道人体的分解机能开始运转也需要消耗大量的热量。相对于那些每天只吃一两顿饭，但是每次都吃得很撑的人，少吃多餐的确健康得多，而且消耗的热量也会更多一些。相关推荐:少食多餐减肥食谱  不要错过早餐  要减肥就不能不吃早餐，不吃早餐很容易在中午或者晚上的时候控制不住自己的嘴，然后一下子就吃多了，比吃早餐的时候摄取的热量还要多。在青少年中，不吃早餐的孩子BMI值通常会比较高，容易引起肥胖。早餐吃什么减肥你知道吗?  每天要喝8杯水  要想瘦就要让自己尽可能多的多消耗热量。与此同时，身体也在不断地消耗水分。因此你需要保持身体液态平衡，吸收和利用好摄入的水分。如何喝水减肥?每天喝8杯水(也就是差不多两升)可以帮助你一天多消耗100卡路里。听上去这个量并不多，但是算算看一个星期就是700卡路里，一个月就是2800卡路里。而且身体里的水分充足还有助于让我们的肝和肾更加健康，让因为缺水而导致上火的可能性降低。  折叠秋天减肥方法  秋天有效快速运动减肥方法一、跑步  跑步是最基本也最有效的有氧运动之一，尤其在秋高气爽的季节里去户外跑步，我们的心情也会变得更加愉悦，而且压力也会得到很好的释放。对于减肥来说，慢跑是最适合的方式，因为它可以让我们体内的脂肪得到更充分的燃烧，并且不易对身体造成伤害，每次坚持跑步三十分钟以上，你会发现自己很快就瘦了下来。跑步的地点选择也很重要，我们应该尽量在树木比较多的公园或者是林荫小路上跑步，这样能够吸收更多的养分，避免在粉尘和尾气比较多的马路上跑步。  秋天有效快速运动减肥方法二、跳绳  跳绳是一个不受地点限制的超强有氧运动，它的运动强度甚至比慢跑还要大，跳绳可以锻炼到全身的肌肉，减少腿部、腹部以及手臂上的顽固脂肪。跳绳也非常的具有趣味性，我们既可以和别人进行比赛，同时也能和自己比赛，在规定的时间内计算自己的跳绳次数，也是一种很不错的挑战方式。  秋天有效快速运动减肥方法三、跳舞  跳舞是一种非常有效的燃脂运动，而且还带有很大的娱乐性，同时也能让我们的体态和身形变得更加完美。经常跳舞的人新陈代谢也比较旺盛，甚至会逐渐的过度到易瘦体质。跳舞的方式有很多种，我们可以根据自己的兴趣来进行选择，无论是性感的肚皮舞还是优雅的芭蕾舞，或者是充满异国情调的拉丁舞，都能把我们带入非常快乐的舞蹈世界里，塑造完美的身材。  秋天有效快速运动减肥方法四、呼啦圈  呼啦圈也是一种非常简单的运动方式，我们平时在家就可以进行，尤其对于大家最烦恼的游泳圈来说，摇呼啦圈是非常好的减肥方式。我们需要知道的是，摇呼啦圈的运动强度相对较低，所以每次至少要晃半个小时以上才能起到减少小肚子的效果，而且一旦停下来也比较容易反弹，所以每天都要坚持，另外摇呼啦圈对腹部也是一种很好的按摩，可以起到解决便秘的作用。  折叠冬天减肥方法  寒冷的冬季想要减肥又不想出门，那么就做家务吧，做家务也是一种很棒的冬季减肥方法。  在做家务的时候要有意识的用自己的力量去运动，没事就擦擦窗户擦擦桌椅，如果可以的话拖地也要用抹布手拖，这样加大了运动量，让更多脂肪在身体里燃烧起到减肥效果。  冬天最适合早上洗澡，因为早上起床后是人体新陈代谢很快的时期，在这个时候又去冲热水洗澡按摩就能够让脂肪更加快速的被分解。可以的话就尝试用粗盐加入温水调成膏状，然后涂抹在腹部进行按摩，这样可以发汗，排除身体里的毒素，促进皮肤和身体的新陈代谢，让松垮垮的腹部皮肤变得更加紧致  在家里看电视无聊的时候可以一边做瑜伽一边看，这样不仅时间过得快还能够让你坚持更长的时间，燃脂效果更好，下面就介绍给大家一个简单的瘦身瑜伽动作，想要瘦的MM赶快来学习了。  平躺在瑜伽垫上，双腿打开和肩膀一样的宽度，膝盖弯曲脚板踩在垫子上，慢慢的吐气，用腹部的力量将身体慢慢的抬起来形成拱桥的形状;将手放在腰部的地方手肘贴地的撑着，注意收紧腹部，将左腿抬起来往上踢，然后换右腿继续，一共踢30次休息一会再继续。");
            myDatabaseHelper.insert(contact1);
            myDatabaseHelper.insert(contact2);
            myDatabaseHelper.insert(contact3);
        }
    }
    @Override
       public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Log.d("show:", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                to_change.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(to_change);
                return  true;
              //  return  true;
            case  R.id.action_change:
                if(if_login==0){
                to_login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(to_login);}
                else startActivity(to_logout);
                return  true;
                //return  true;
            default: return super.onOptionsItemSelected(item);
        }

    }
}
