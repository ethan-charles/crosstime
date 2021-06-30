<template>
	<view>
		<view class="header" :style="{'height':titleBarHeight,'padding-top':statusBarHeight,'background-color': '#F8F8F8'}">
			<image class='header-back' src='/static/logo.png' style="height: 50upx; width: 50upx;" @click="gotoConn()"></image>
		</view>
		
		<view style="width: 50%; margin: auto;margin-bottom: 20px; display: flex; flex-direction: row; justify-content: center;">
			<xfl-select 
			:list="list"
			:clearable="false"
			:showItemNum="5" 
			:listShow="false"
			:isCanInput="false"  
			:style_Container="listBoxStyle"
			:placeholder = "'placeholder'"
			:initValue="'中'"
			:selectHideType="'independent'"
			style="width: 200rpx;"
			>
			</xfl-select>
		</view>
		
		<view :style="{'height':titleBarHeight,'padding-top':statusBarHeight}"></view>
		
		<view class="function">
			<input v-model="value" focus placeholder="在此输入文字" style="width: 400upx; margin: auto;margin-bottom: 20px;">
			<view class="tag">
				<image src='../../static/profession.png' @click="goprofession()" style="height: 100upx; width: 100upx;"></image>
				<view style="font-size: small;">专业模块</view>
			</view>
		</view>
		
		<view class="classification">
			<view class="tag" @click="goTag(0)">
				<image src='../../static/01.gif' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">消息</view>
			</view>
			<view class="tag" @click="goTag(1)">
				<image src='../../static/02.gif' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">历史</view>
			</view>
			<view class="tag" @click="goTag(2)">
				<image src='../../static/03.png' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">收藏</view>
			</view>
			<view class="tag" @click="goTag(3)">
				<image src='../../static/04.png' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">广场</view>
			</view>
			<view class="tag" @click="goTag(4)">
				<image src='../../static/05.gif' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">排行榜</view>
			</view>
		</view>
		<br>
		<view>
			<image src="../../static/study-page.png" style="width:1080rpx; height: 768rpx;"></image>
		</view>
		<view class='btns'>
			<image src="../../static/images/study.gif" @click="gopage(1)"style="width:370rpx; height: 200rpx;"></image>
			<image src="../../static/images/teach.png" @click="gopage(0)"style="width:370rpx; height: 200rpx;"></image>
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
			goprofession(){
				uni.navigateTo({
					url: "../profession/profession"
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

<style lang="scss">
	@import '@/common/uni-nvue.scss';
	.checkbox{
		position: relative;
		
		width: 80%; 
		margin: auto; 
		display: flex; 
		flex-direction: row; 
		justify-content: center;
	}
	.wind{
		width: 80%; 
		margin: auto;
		margin-bottom: auto;
		display: flex;
		flex-direction: row; 
		justify-content: center;
		font-size: 18px;
	}
	.example {
		padding: 10px;
		background-color: #fff;
	}
	
	.text {
		font-size: 14px;
		color: #333;
		margin-bottom: 10px;
	}
	.container {
		position: relative;
	}
	.btns {
		display: flex;
		align-items: center;
		position: fixed;
		flex-direction: row;
		bottom: 0;
		z-index: 100;
		left:0;
		align-self: center;
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
	.function {
		display: flex;
		align-items: stretch;
		align-content: stretch;
		justify-content: space-around;
		flex-wrap: wrap;
		width: 20%;
	}
	.tag {
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 20%;
		margin-top: auto;
	}

</style>
