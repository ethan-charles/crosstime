<template>
	<view>
		<view>
			<image src="../../static/clock1.png"></image>
			<image src="../../static/logo.png" style="width: 50rpx;"></image>
		</view>
		
		<view class="text-area">
			<text class="title">个人中心</text>
		</view>
		<uni-list class="list">
			<uni-list-item title="我的主页" showArrow thumb="/static/tabs/phone.png" thumb-size="base" clickable @click="uni.navigateBack({delta: 1})" />
			<uni-list-item title="账号与安全" showArrow thumb="/static/tabs/magnifier.png" thumb-size="base" clickable @click="goSb(0)" />
			<uni-list-item title="我的剩余学习时间" showArrow rightText="35min" thumb="/static/tabs/favorate.png" thumb-size="base" clickable @click="goSb(1)" />
			<uni-list-item title="邀请好友免费获得学习时间" note="您的邀请码为:XXXXXXXX" showArrow thumb="/static/tabs/phone.png" thumb-size="base" clickable @click="goSb(2)" />
			<uni-list-item title="消息与提醒" showArrow thumb="/static/tabs/asking-mark.png" thumb-size="base" clickable @click="goSb(3)" />
			<uni-list-item title="清除缓存" showArrow rightText="154.2M" thumb="/static/tabs/asking-mark.png" thumb-size="base" clickable @click="goSb(4)" />
			<uni-list-item title="联系我们" showArrow thumb="/static/tabs/asking-mark.png" thumb-size="base" clickable @click="goSb(5)">
				<template slot="footer">
					<image class="slot-image" src="../../static/C.png" mode="widthFix"></image>
				</template>
			</uni-list-item>
			<uni-list-item title="关于我们" showArrow thumb="/static/tabs/asking-mark.png" thumb-size="base" clickable @click="goSb(6)" />
		</uni-list>
		<view class="exite">
			<image src="../../static/exite.png" style="width:370rpx; height: 200rpx;"></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			goSb: function(i) {
				switch (i) {
					case 0:
						uni.navigateTo({
							url: "../teach/teach"
						});
						break;
					case 1:
						uni.navigateTo({
							url: "mycollection"
						});
						break;
					case 2:
						uni.navigateTo({
							url: "mycollection"
						});
						break;
					case 3:
						uni.showToast({
							title: '暂未开放',
							icon: 'error'
						});
						break;
					case 4:
						uni.showToast({
							title: '暂未开放',
							icon: 'error'
						});
						break;
					case 5:
						uni.navigateTo({
							url: "helpcenter"
						});
						break;
					case 6:
						uni.showToast({
							title: '暂未开放',
							icon: 'error'
						});
						break;
				}
			},
		}
	}
</script>

<style lang="scss">
	.list {
			margin-right: 5rpx;
			display: flex;
			flex-direction: column;
			align-items: center;
	}

	@import '@/common/uni-nvue.scss';

	.slot-box {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		align-items: center;
	}

	.slot-image {
		/* #ifndef APP-NVUE */
		display: block;
		/* #endif */
		margin-right: 10px;
		width: 30px;
		height: 30px;
	}

	.slot-text {
		flex: 1;
		font-size: 14px;
		color: #4cd964;
		margin-right: 10px;
	}
	.exite {
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 25%;
		margin-top: auto;
	}
</style>
