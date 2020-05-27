package com.example.util;

public class PayConstants {
	/**
	 * 分布式锁工程前缀
	 */
	public static final String DLOCK_PREFIX = "XY_PAY_GATE";
	/* 业务日志logger */
	public static final String BUSINESS_LOGGER_NAME="businessLogger";
	public static final String BUSINESS_ORDER = "businessOrderLogger";
	public static final String BUSINESS_TASK = "businessTaskLogger";
	public static final String BUSINESS_ALARM = "businessAlarmLogger";
	public static final String BUSINESS_NOTIFY = "businessNotifyLogger";
	public static final String VISIT_LOGGER = "visitLogger";
	public static final String WEB_LOGGER = "webLogger";
	public static final String PAYCONFIG_LOGGER = "payConfigLogger";
	public static final String MEMBER_CENTER_LOGGER = "memberCenterLogger";
	//报警日志监控
	public static final String THIRDALARMLOGGER = "thirdalarmLogger";

	//阿里云监控日志
	public static final String BUSINESS_LOGGER_MONITOR = "BUSINESS_LOGGER_MONITOR";

	//交易工厂
	public static final String TRADE_ERVICE_FACTORY = "tradeServiceFactory";
	//退款
	public static final String REFUND_ERVICE_FACTORY = "refundServiceFactory";
	//业态工厂
	public static final String INDUSTRY_Factory = "industryConfigFactory";

	/**
	 * 工程默认编码，包括流解析，字符集
	 */
	public static final String PROJECT_DEFAULT_ENCODING="utf-8";
	/** 系统异常常数 */
	public static final int SUCCESS = 0xFF0001;// 支付中心操作成功
	public static final int SERVICE_SYSTEM_FALIURE = 0xFF0002;// 系统级别异常
	public static final int SERVICE_DATABASE_FALIURE = 0xFF0003;// 数据库异常
	public static final int NO_ALIVE_DATASOURCE = 0xFF0004;// 没有可用的数据源
	public static final int NOT_SUPPORT = 0xFF0005;// 当前不支持
	public static final int PARAMS_INVALID = 0xFF0006;// 参数无效
	public static final int NO_DATA = 0xFF0007;// 支付中心没有数据
	public static final int NOT_SAFE_IPADDRESS = 0xFF0008;// 不在安全ip列表以内
	public static final int OVER_TOP_VALUE = 0xFF0009;// 参数超出了期限值,一般是取得数值太大
	public static final int DATA_EXISTED = 0xFF0010;// 数据已经存在
	public static final int REPEATED_SUBMIT_PAYMENT = 0xFF0011;// 重复提交,支付
	public static final int UNKNOW_ERROR = 0xFF0012;// 未知错误
	
	
	/** 第三方支付错误信息 */
	public static final int THIRD_PAY_ERROR= 0xFF0013;// 第三方跳转失败
//	public static final int UNKNOW_ERROR = 0xFF0012;// 未知错误
	
	//不对外进行提示
	public static final int SIGN_ERROR = 0xFF0014;// 验证错误
	public static final int ANALYZE_ERROR = 0xFF0015;//解析文本或者xml错误
	public static final int TYPE_ERROR = 0xFF0016;//类型错误
	public static final int MONEY_NOT_EQUAL=0xFF0017; //金额不相同
	
	
	/** 业务常数 */
	public static final int QUERY_TRADE_UNEXIST = 0xEE0001;// 交易不存在
	public static final int QUERY_TRADE_PENDING = 0xEE0002;// 交易等待支付
	public static final int QUERY_TRADE_SUCCESS = 0xEE0003;// 交易完成
	public static final int QUERY_TRADE_CLOSED = 0xEE0004;// 交易被关闭
	public static final int QUERY_OVER_TIME = 0xEE0005;// 交易超过了查询的期限
	public static final int QUERY_TRADE_SIGN_ERROR = 0xEE0006;// 交易查询验证错误
	public static final int QUERY_HTTP_ERROR = 0xEE0007;// 交易查询网络错误
	public static final int QUERY_TRADE_OTHER = 0xEE0008;// 交易查询失败
	public static final int QUERY_TRADE_REFUND= 0xEE0009;// 交易已经退款
	public static final int QUERY_TRADE_REFUND_FAIL= 0xEE0012;// 交易已经退款失败
	public static final int QUERY_TRADE_TRANSFER = 0xEE0010;// 交易充退成功
	public static final int QUERY_TRADE_TRANSFERING = 0xEE0014;// 交易充退成功
	public static final int QUERY_TRADE_TRANSFER_FAIL = 0xEE0013;// 交易冲退失败
	public static final int QUERY_TRADE_FAIL = 0xEE0011;// 交易失败，可能是支付失败，也可能是退款失败
	public static final int QUERY_TRADE_REFUND_PENDING= 0xEE0015;// 交易退款处理中

	public static void main(String[] args) {
		System.out.println(0xEE0008);
	}

	/** http 常数 */
	public static final int HTTP_NO_FORMAT_RESPONSE = 0xEF0001;// 返回的不是良好格式的文本
	public static final int HTTP_OTHER_ERROR = 0xEF0002;// HTTP返回statuscode不是200

	/*************** 队列常数  ********************/	
	/** 队列  常数  */
	public static final int QUEUE_TYPE_PAY = 1;  //支付
	public static final int QUEUE_TYPE_REFUND = 2;//退款
	public static final int QUEUE_TYPE_TRANSFER = 3;//充退转账
	public static final int QUEUE_TYPE_RECHARGE = 4;//充值
	public static final int QUEUE_TYPE_SYN_REFUND = 5;//微信退款回调
	public static final int QUEUE_TYPE_PAY_SYN = 6;  //支付
	public static final int QUEUE_TYPE_REVOKE = 7;  // 撤销
	public static final int QUEUE_REVOKE_TRADE_RESULT = 8;  // 撤销处理结果;
	public static final int QUEUE_CLOSE_TRADE_RESULT = 9;  //  关闭处理结果;
	/** 队列操作 status */
	public static final int QUEUE_STATUS_ACTIVE = 1;//消息可用
	public static final int QUEUE_STATUS_LOCKED = 3;//消息被占用
	public static final int QUEUE_STATUS_DELETED = 5;//消息删除（表示成功）
	public static final int QUEUE_STATUS_CANCEL = 4;//消费作废（表示失败的）
	
	/** 队列结果状态 status */
	public static final int QUEUE_STATUS_NOT_CONSUME = 1;//未消费
	public static final int QUEUE_STATUS_CONSUMER_SUCCESS = 2;//消费成功(包括消费次数已经用完，也标记成功，但是队列的阿状态不一样)
	public static final int QUEUE_STATUS_CONSUMER_FAILED = 3;//消费失败

	
	public static final int QUEUE_MAX_CONSUME_COUNT = 8;//最大消费次数
	public static final int QUEUE_MAX_CONSUME_COUNT_PAY_SYN = 30;//最大消费次数
	public static final int QUEUE_MAX_CONSUME_COUNT_REFUND_SYN = 102;//最大消费次数

	
	
	/****************  支付   ********************/	
	public static final int  PAY_LOG_TYPE_CREATE = 1;//交易发起
	public static final int  PAY_LOG_TYPE_CLOSE = 2;//交易关闭
	public static final int  PAY_LOG_TYPE_REVOKE = 21;//交易撤销
/*	public static final int  PAY_LOG_TYPE_NOTIFY_WEB = 3;//交易支付通知
	public static final int  PAY_LOG_TYPE_NOTIFY_SERVER = 4;//交易支付通知
*/	
	
	public static final int PAY_STATUS_CREATE = 1;//交易产生
	public static final int PAY_STATUS_REFUND = 2;//交易退款
	public static final int PAY_STATUS_SUCCESS = 3;//交易支付成功
	public static final int PAY_STATUS_INPROCESS = 30;//交易支付受理成功


	public static final int PAY_STATUS_FAIL = 4;//交易支付失败
	public static final int PAY_STATUS_CLOSE = 5;//交易关闭
	public static final int PAY_STATUS_SUCCESS_CLOSE = 6;//交易成功，关闭
	public static final int PAY_STATUS_CLOSE_REFUND = 7;//交易关闭并产生了退款
	public static final int PAY_STATUS_CLOSE_THIRD_NO_TRADE = 8;//交易关闭,第三方支付平台交易不存在
	public static final int PAY_STATUS_OTHER = 10;//未知状态

	public static final long PAY_CHANGE_TIME_THRESHOLD = 3*60*60*1000;//交易号 3小时换一次
	
	public static final int PAY_NOTIFY_STATUS_NONE = 5;//未通知
	public static final int PAY_NOTIFY_STATUS_WEB_SUCCESS = 3;//浏览器通知
	public static final int PAY_NOTIFY_STATUS_SERVER = 4;//服务器通知
	public static final int SYN_PAY_STATUS_SUCCESS = 10;//同步支付成功
	public static final int SYN_PAY_STATUS_FAIL = 11;//同步支付失败

	/****************  退款   ********************/	
	
	public static final int REFUND_CLOSE = 10;//退款关闭
	public static final int REFUND_SUBMIT_SUCCESS = 1;//退款受理成功
	public static final int REFUND_SUBMIT_FAIL = 2;//退款受理失败
	public static final int REFUND_UNKNOW = 3;//退款批次号存在，结果未知
	public static final int REFUND_HAVE_SUBMIT = 4;//已经处理退款
	public static final int REFUND_NOTIFY_FAIL = 6;//退款通知失败
	public static final int REFUND_NOT_SUPPORT = 9;//不支持退款
	
	//退款状态
	public static final int  REFUND_STATUS_CREATE = 1;//退款发起
	public static final int  REFUND_STATUS_LOCK = 4;//退款中
	public static final int  REFUND_STATUS_FAIL = 2;//退款失败
	public static final int  REFUND_STATUS_SUCCESS = 3;//退款成功
	
	public static final int REFUND_LOG_OP_SUBMIT = 1;//退款提交
	public static final int REFUND_LOG_OP_NOTIFY = 2;//退款通知
	
	
	//退款类型
	public static final int REFUND_TYPE_SYN = 1;//同步退款
	public static final int REFUND_TYPE_ASYN = 2;//异步退款
	
	public static final int REFUND_TYPE_AUTO = -1;//自动退款
	public static final int REFUND_TYPE_SUPPLIER = 1;//商户发起退款
	public static final int REFUND_TYPE_USER = 2;//用户发起退款
	public static final int REFUND_TYPE_CUSTOMSRVICE = 3;//客服发起退款
	
	//退款对应支付类型
	public static final int REFUND_SOURCE_COMMON = 1;//正常退款
	public static final int REFUND_SOURCE_INVALID = 2;//重复支付退款
	
	/**
	 * 充退转账 状态常数
	 */
	public static final int REFUND_TRANSFER_LOG_SUBMIT = 3;//充退款提交
	public static final int REFUND_TRANSFER_LOG_NOTIFY = 4;//充退款通知
	
	//冲退转帐状态
	public static final int  REFUND_TRANSFER_STATUS_CREATE = 1;//冲退发起
	public static final int  REFUND_TRANSFER_STATUS_FAIL_TRANSFER = 5;//冲退失败允许转帐
	public static final int  REFUND_TRANSFER_STATUS_FAIL = 6;//冲退失败
	public static final int  REFUND_TRANSFER_STATUS_SUCCESS = 4;//冲退成功
	public static final int  REFUND_TRANSFER_STATUS_HANDLE = 3;//冲退处理中
	
	
	public static final int REFUND_TRANSFER_UNHANDLE = 0;			//未处理
	public static final int REFUND_TRANSFER_SUBMIT_SUCCESS = 2;	//充退受理成功
	public static final int REFUND_TRANSFER_SUCCESS = 4;			//充退处理成功
	public static final int REFUND_TRANSFER_FAIL_TO_CUSTOMER = 5;	//充退失败，客服重新补录
	public static final int REFUND_TRANSFER_FAIL_TO_CAIWU = 6;		//充退失败，财务线下处理
	public static final int REFUND_TRANSFER_HAVE_HANDLE = 7;		//已经处理不用在提交了
	
	public static final int REFUND_TRANSFER_COUNT = 5;//最大充退次数
	
	/************************* 业务方 *******************/
//	public static final int PAY_WOWO = 1;//主站支付业务
//	public static final int PAY_MOVIE = 2;//电影支付业务
//	public static final int PAY_MOVIE_MOBILE = 4;//手机端电影支付业务
//	public static final int PAY_DAZHE = 3;//打折卡支付业务
//	public static final int PAY_MEIMEITUAN = 12;//美美团的支付业务
//	public static final int PAY_RECHARGE = 5; //主站的充值业务
//	public static final int PAY_MD_MOBILE=40;//买单手机支付业务
//	public static final int PAY_MD_MOBILE_RECHARGE=21;//网店通手机充值业务
//	public static final int PAY_MD_MOBILE_ACCOUNT=22;//网店通手机余额支付业务
//	public static final int PAY_MD_WIRELESS=23;//无线支付
//	public static final int PAY_MD_PAYCENTER=24;// 支付中心
	public static final int PAY_YZ_MAKE = 10;//云纵制造服务窗支付业务
	public static final int PAY_YZ_JIANGXIN = 20;//云纵匠心服务市场支付业务
	/*************************  缓存key值 *********************/
	public static final String EVENT_SCHEDULED = "Paygate_EventScheduled_data";
	public static final String EVENT_CONSUME = "Paygate_EventComsume_data";

	//日志中的敏感词数组
	public static String[] sensitiveWord = {"buyer_id","buyer_email","seller_id","seller_email","pay_user"};


	//MDC key
	public static final String MDC_TRADE_ID = "tradeId";
	public static final String MDC_TRADE_NO = "tradeNo";
	public static final String MDC_UNIQUE_ID = "traceRootId";


	//
	public static String RES_SOURCE = "_SOURCE";
	public static String PG_CODE = "PG_CODE";
	public static String PG_MSG = "PG_MSG";
	public static String PG_THIRD_CODE = "PG_THIRD_CODE";

	//商家是否开启余额账户
	public static Integer IS_OPEN_BALANCE = 1;
	public static Integer NO_OPEN_BALANCE = 0;

	public static String REDIS_MEMNOTIFY = "REDIS_MEMNOTIFY";
	/**
	 * mkb-满课宝应用id
	 */
	public static String MKB_OPEN_APPID = "910033";

	/** 路由字段拼接 */
	public static String ROUTE_PREFIX = "XY";

	/** 路由字段拼接:用于区分当前拼接到路由为isvMerchantId; */
	public static String ROUTE_ISV_MER_PREFIX = "ISV";

	/**
	 * redis异常队列key
	 */
	public static String RESULT_KEY = "resultKey";

	/**
	 * 修复通知notify队列常量
	 */
	public static String REDIS_NOTIFY_QUEUE = "NOTIFY_REDIS_QUEUE";
	public static String NOTIFY_QUEUE_DO = "notifyQueueDO";
	public static String NOTIFY_QUEUE_INFO_DO = "notifyQueueInfoDO";

	/**
	 * 修复通知队列常量
	 */
	public static String REDIS_QUEUE = "NOTIFY_QUEUE";
	public static String QUEUE_DO = "queueDO";
	public static String QUEUE_INFO_DO = "queueInfoDO";

	/**
	 * 银联直连相关;
	 *
	 */

	/**
	 * 银联直连平台:生产环境验签公钥证书certID;
	 */
	public static final String UNION_PRODUCE_ENV_CERT_ID = "69597475696";

	/**
	 * 银联直连平台:测试环境验签公钥证书certID;
	 */
	public static final String UNION_TEST_ENV_CERT_ID = "69026276696";

}
