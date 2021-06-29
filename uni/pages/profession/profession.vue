<template>
	<view>
		<view class="header" :style="{'height':titleBarHeight,'padding-top':statusBarHeight,'background-color': '#F8F8F8'}">
			<image class='header-back' src='/static/logo.png' style="height: 50upx; width: 50upx;" @click="gotoConn()"></image>
			<view class="header-title">专业模式</view>
		</view>
		<view :style="{'height':titleBarHeight,'padding-top':statusBarHeight}"></view>
		
		<view>
			<input v-model="value" focus placeholder="搜索老师" style="width: 80%; margin: auto;margin-bottom: 20px;">
		</view>
		
		<view class='purchase'>
			<image src="../../static/purchase/1.png" style="width:370rpx; height: 200rpx;"></image>
			<br>
			<image src="../../static/purchase/2.png" style="width:370rpx; height: 200rpx;"></image>
			<br>
			<image src="../../static/purchase/3.png" style="width:370rpx; height: 200rpx;"></image>
		</view>
		
		<view class='btns'>
			<image src="../../static/profession-1.png" style="width:370rpx; height: 200rpx;"></image>
			<image src="../../static/profession-2.png" style="width:370rpx; height: 200rpx;"></image>
			<image src="../../static/profession-3.png" style="width:370rpx; height: 200rpx;"></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				listBoxStyle: `height: 40px; font-size: 16px;`,
				list: [
					'中',
					'英',
					'韩',
					'日', 
					'西',
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
		created() {
			var that = this;
			uni.getSystemInfo({
				success: function(res) {
					if (res.model.indexOf('iPhone') !== -1) {
						that.titleBarHeight = '44px';
					} else {
						that.titleBarHeight = '48px';
					}
					that.statusBarHeight = res.statusBarHeight + 'px'
				}	
			})
			
		},
		methods: {
			gotoConn(){
				uni.navigateTo({
					url: "../mine-study/mine-study"
				});
			},
			gopage(e){
				if (e){
					uni.navigateTo({
						url: "../study/study"
					});
				}else{
					uni.navigateTo({
						url: "../teach/teach"
					});
				}
			}
			
		}
	}
</script>

<style>
	.btns {
		margin-top: 40rpx;
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
	}
	.header {
		display: flex;
		align-items: center;
		top: 0;
		position: fixed;
		width: 100%;
		z-index: 100;
		left:0;
	}
	.header-title {
		position: absolute;
		left: 50%;
		font-size: 38upx;
		transform: translateX(-50%);
	}
	.header-back {
		position: absolute;
		left:15upx;
		font-size:30upx;
		padding: 10upx;
		/* border-radius: 50%; */
	}
	.classification {
		display: flex;
		align-items: stretch;
		align-content: stretch;
		justify-content: space-around;
		flex-wrap: wrap;
	}
	.tag {
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 15%;
		margin-top: 20px;
	}

</style>
