<template>
	<view class="content">
		<image class="bg-set" src="../../static/homepage1.png"></image>
		<view class="container">
				<view class="user-info-box" @click="gopage">
					<button class="user-logoin-title" open-type="getUserProfile">点击开始</button>
				</view>
		</view>
		
		
		<view style="width: 80%; margin: auto;margin-bottom: 20px;">
			<xfl-select 
			:list="list"
			:clearable="false"
			:showItemNum="5" 
			:listShow="false"
			:isCanInput="false"  
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
		methods: {
			visibleChange(isShow){ // 列表框的显示隐藏事件
				console.log('isShow::', isShow);
			},
			change({newVal, oldVal, index, orignItem}){ 
				console.log(newVal, oldVal, index, orignItem);
			},
			gopage(){
				uni.navigateTo({
					url: "../teach/teach"
				});
			}
		},
	}
		// components: { xflSelect }
</script>

<style>
	.bg-set{
	    position: fixed;
	    width: 100%;
	    height: 100%;
	    top: 0;
	    left: 0;
	    z-index: -1;
	}
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
