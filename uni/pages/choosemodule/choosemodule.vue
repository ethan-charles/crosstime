<template>
	<view class="container">
		<view class="header" :style="{'height':titleBarHeight,'padding-top':statusBarHeight,'background-color': '#F8F8F8'}">
			<view class="header-title">请选择模式</view>
		</view>
		<view>
			<image src="../../static/teach.png" @click="gopage(0)" class="teach"></image>
			<image src="../../static/study.png" @click="gopage(1)" class="study"></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				statusBarHeight: 0,
				titleBarHeight: 0,
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
	.teach{
		position: relative;
		height: 350rpx;
		width: 350rpx;
		top: 770rpx;
		left: 70rpx;
	}

	.study{
		position: relative;
		height: 350rpx;
		width: 350rpx;
		top: 550rpx;
	}
	.container {
		position: relative;
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
</style>
