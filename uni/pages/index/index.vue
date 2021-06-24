<template>
	<view class="content">
		<image class="logo" src="/static/logo.png" @click="getUserProfile"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>
		<view class="container">
				<view class="user-info-box" @click="getUserProfile" v-if="!hasUserInfo">
					<!-- <image class="user-image" src="../../static/nouser.jpg" mode="widthFix"></image> -->
					<button class="user-logoin-title" open-type="getUserProfile">点击开始</button>
				</view>
				<view class="user-info-box" v-else>
					<view class="user-info">
						<image bindtap="bindViewTap" class="user-image" :src="userInfo.avatarUrl" mode="widthFix"></image>
						<text class="user-logoin-title">{{userInfo.nickName}}</text>
					</view>
				</view>
		</view>
		
		
		<view style="width: 80%; margin: auto;margin-bottom: 20px;">
			<xfl-select 
			:list="list"
			:clearable="false"
			:showItemNum="5" 
			:listShow="true"
			:isCanInput="true"  
			:style_Container="listBoxStyle"
			:placeholder = "'placeholder'"
			:initValue="'请选择语言'"
			:selectHideType="'independent'"
			>
			</xfl-select>
		</view>
	
		
	</view>
</template>

<script>
	import xflSelect from '../../components/xfl-select/xfl-select.vue';
	export default {
		data() {
			return {
				listBoxStyle: `height: 40px; font-size: 16px;`,
				list: [
					'中文',
					'英语',
					'韩语',
					{value: '日语', disabled: true},
					'德语',
					'西班牙语',
					'意大利语',
					'葡萄牙语',
				],
				userInfo: {},
				hasUserInfo: false,
				canIUseGetUserProfile: false,
				code:'',
				openid: '',
				session_key: '',
				encryptedData: ',',
				iv: '',
			}
		},
		onLoad() {
			var that = this;
		    if (wx.getUserProfile) {
		      that.canIUseGetUserProfile = true;
		    }
			that.getUserCode();
		 },
		methods: {
			visibleChange(isShow){ // 列表框的显示隐藏事件
				console.log('isShow::', isShow);
			},
			change({newVal, oldVal, index, orignItem}){ 
				console.log(newVal, oldVal, index, orignItem);
			},
			getUserCode(){
				wx.login({
				  provider: 'weixin',
				  success: res => {
						this.code = res.code;
						console.log(this.code);
				        }
				});
			},
			
			getUserProfile(e) {
				var that = this;
			    wx.getUserProfile({
					desc: '用于完善资料',
					success: res => {
						that.userInfo = res.userInfo;
						that.iv = res.iv;
						that.encryptedData = res.encryptedData;
						console.log(that.userInfo.nickName);
						console.log(that.encryptedData);
						that.hasUserInfo = true;
					}
			    }),
				wx.request({
						url: 'http://localhost:8080/springboot/user/login',
						method: 'POST',
						header:{ 'content-type': 'application/x-www-form-urlencoded'},
						data:{
							'user_name':that.userInfo.name,
							'user_encryptedData': that.encryptedData,
						},
						success:function(res){
							var resdata = res.data;
							if (resdata == true){
								wx.showToast({    //这是微信小程序里面自带的成功弹窗
								    title:'登录成功',  //弹窗里面的内容
								    icon:'success',  //图标
								    duration:2000,   //弹窗延迟的时间
								    success:function(){
										wx.navigateTo({  //保留当前页面，跳转到应用内的某个页面
											url: '../index/index',   //跳转的页面
										})
								    }
								})
							}else{
								wx.showToast({
								    title: '登录失败',
									icon:'none',
								    duration: 2000,
								    })
							}
						}
					})
				},
		},
		components: { xflSelect },

		 /* 
			// 或者在 main.js 中注册为全局组件 
			import xflSelect from './components/xfl-select/xfl-select.vue';
			Vue.component('xfl-select', xflSelect);
		*/
	}
</script>

<style>
	.user-info-box{
		width: 100%;
		box-sizing: border-box;
		padding: 30upx;
		display: flex;
		flex-direction: row;
		align-items: center;
		background-color: rgb(255, 255, 255);
		margin-bottom: 30upx;
		/* .user-image{
			width: 130upx;
			height: 130upx;
			border-radius: 65upx;
		} */
		/* .user-info{
			flex: 1;
			display: flex;
			flex-direction: column;
			padding-left: 20upx;
			box-sizing: border-box;
			z-index: 10;
			.user-logoin-title{
				font-size:36upx;
				font-weight:500;
				color:rgba(255, 85, 0, 1.0);
			}
		} */
}
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
