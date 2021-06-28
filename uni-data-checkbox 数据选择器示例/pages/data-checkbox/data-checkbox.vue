<template>
	<view>
		<uni-group title="更多样式-button">
			<view class="text">选中：{{JSON.stringify(formData.hobby)}}</view>
			<uni-data-checkbox mode="button" multiple v-model="formData.hobby" :localdata="hobby"></uni-data-checkbox>
		</uni-group>

		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				formData: {
					value: 1,
					hobby: [1]
				},
				
				hobby: [{
					text: '足球',
					value: 0
				}, {
					text: '篮球',
					value: 1
				}, {
					text: '游泳',
					value: 2
				}],
				
			}
		},
		onLoad() {},
		onReady() {},
		methods: {}
	}
</script>

<style lang="scss">
	@import '@/common/uni-nvue.scss';

	.example {
		padding: 10px;
		background-color: #fff;
	}

	.text {
		font-size: 14px;
		color: #333;
		margin-bottom: 10px;
	}
</style>
