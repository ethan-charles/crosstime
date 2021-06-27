<template>
	<view>
		<view class="header" :style="{'height':titleBarHeight,'padding-top':statusBarHeight,'background-color': '#F8F8F8'}">
			<image class='header-back' src='/static/logo.png' style="height: 50upx; width: 50upx;" @click="gotoConn()"></image>
			<view class="header-title">教学界面</view>
		</view>
		<view :style="{'height':titleBarHeight,'padding-top':statusBarHeight}"></view>
		<view class="classification">
			<view class="tag" @click="goTag(0)">
				<image src='../../static/01.gif' style="height: 50upx; width: 50upx;"></image>
				<view style="font-size: small;">#分类标签</view>
			</view>
			<view class="tag" @click="goTag(1)">
				<image src='../../static/02.gif' style="height: 50upx; width: 50upx;"></image>
				<view style="font-size: small;">#分类标签</view>
			</view>
			<view class="tag" @click="goTag(2)">
				<image src='../../static/04.png' style="height: 50upx; width: 50upx;"></image>
				<view style="font-size: small;">#分类标签</view>
			</view>
			<view class="tag" @click="goTag(3)">
				<image src='../../static/05.gif' style="height: 50upx; width: 50upx;"></image>
				<view style="font-size: small;">#分类标签</view>
			</view>
		</view>
		<view class='btns'>
			<view>
			<button>教学</button>
			</view>
			<view>
			<button>学习</button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
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
					url: "../mine/mine"
				});
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
